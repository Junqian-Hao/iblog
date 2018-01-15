package com.nuc.iblog.controler;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nuc.iblog.entity.User;
import com.nuc.iblog.service.ClArticleService;
import com.nuc.iblog.service.ClCategoryService;
import com.nuc.iblog.util.SensitiveWordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Created by Tyranitarx on 2018/1/11.
 *
 * @Description :文章增删改
 */
@Controller
@RequestMapping("cl")
public class ClWriteController {
    Logger log = LoggerFactory.getLogger(ClWriteController.class);
    @Autowired
    private ClArticleService clArticleService;
    @Autowired
    private ClCategoryService clCategoryService;

    @RequestMapping("/writeArticle")
    public String toWritePage(HttpServletRequest request) {
        log.info("用户" + request.getSession().getAttribute("user") + "写博客");
        request.setAttribute("Categories", clCategoryService.getAllCategory());
        return "/cl/write";
    }

    private User user;
    private Set<String> sensitiveWordLib;

    @RequestMapping("/writeSubmit")
    public String WriteAndtoSelfBlog(String title, String summary, String catname, String content, HttpServletRequest request) {
        sensitiveWordLib = (Set<String>) request.getSession().getServletContext().getAttribute("sensitiveWordLib");
        if (sensitiveWordLib == null)
            SensitiveWordUtil.init(SensitiveWordUtil.getSensitiveWordLib());
        else
            SensitiveWordUtil.init(sensitiveWordLib);
        content = SensitiveWordUtil.replaceSensitiveWord(content, '*', SensitiveWordUtil.MinMatchTYpe);
        log.info("catid" + catname);
        user = (User) request.getSession().getAttribute("User");
        clArticleService.insertArticle(user.getUid(),
                catname, title, summary, content);

        return "redirect:/cl/selfBlog";
    }

    @RequestMapping("/updateArticle")
    public String toUpdatePage(HttpServletRequest request, int aid) {
        request.setAttribute("Categories", clCategoryService.getAllCategory());
        request.setAttribute("Article", clArticleService.getArticle(aid));
        return "/cl/write";
    }

    @RequestMapping("/updateSubmit")
    public String updateSubmit(HttpServletRequest request, String title, String summary, String catname, String content) {
        String aid = request.getParameter("aid");
        sensitiveWordLib = (Set<String>) request.getSession().getServletContext().getAttribute("sensitiveWordLib");
        if (sensitiveWordLib == null)
            SensitiveWordUtil.init(SensitiveWordUtil.getSensitiveWordLib());
        else
            SensitiveWordUtil.init(sensitiveWordLib);
        content = SensitiveWordUtil.replaceSensitiveWord(content, '*', SensitiveWordUtil.MinMatchTYpe);
        user = (User) request.getSession().getAttribute("User");
        log.info("catname" + catname);
        if (aid != null)
            clArticleService.updateArticle(user.getUid(), Integer.parseInt(aid), catname, title, summary, content);
        else
            clArticleService.insertArticle(user.getUid(), catname, title, summary, content);
        return "redirect:/cl/selfBlog";
    }

    private int status;
    private Map<String, String> returnMap;

    @ResponseBody
    @RequestMapping("/deleteArticle")
    public Map<String, String> deleteArticle(@RequestBody String json) {
        returnMap = new HashMap<String, String>();
        JSONObject object = JSON.parseObject(json);
        status = clArticleService.deleteArticle((Integer) object.get("aid"));
        if (status == 1) {
            returnMap.put("code", "1");
            return returnMap;
        } else {
            returnMap.put("code", "0");
            return returnMap;
        }
    }
}
