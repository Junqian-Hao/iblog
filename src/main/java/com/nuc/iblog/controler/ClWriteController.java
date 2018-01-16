package com.nuc.iblog.controler;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nuc.iblog.entity.User;
import com.nuc.iblog.service.ClArticleService;
import com.nuc.iblog.service.ClCategoryService;
import com.nuc.iblog.util.SensitiveWordUtil;
import com.sun.jndi.toolkit.url.UrlUtil;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;


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


    private Map<String, String> returnMap;


    @RequestMapping("/deleteArticle")
    public String deleteArticle(int aid) {
        clArticleService.deleteArticle(aid);
        return "redirect:/cl/selfBlog";
    }

    private Map<String, String> returnmap;
    private UUID uuid;
    private String uuids;

    @ResponseBody
    @RequestMapping(value = "/BlogPicUpload", method = RequestMethod.POST)
    public Map<String, String> productDetailUpload(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile file) {
        log.info("上传详情图片");
        returnmap = new HashMap<String, String>();
        //分别获取的是变量名file---文件类型---文件名
        if(file!=null) {
            try {
                uuid = UUID.randomUUID();
                uuids = uuids.replaceAll("-", "");
                //使用StreamsAPI方式拷贝文件
                Streams.copy(file.getInputStream(), new FileOutputStream(request.getServletContext().getRealPath("/") + "BlogPic/" + uuids + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."))), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            returnMap.put("success","0");
            returnMap.put("message","上传失败");
            return returnMap;
        }
        returnMap.put("success","1");
        returnMap.put("message","上传成功");
        returnMap.put("url","localhost:8080"+request.getServletContext().getRealPath("/") + "BlogPic/" + uuids + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")));
        return returnMap;
    }
}
