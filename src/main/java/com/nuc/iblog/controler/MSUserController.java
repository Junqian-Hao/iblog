package com.nuc.iblog.controler;

import com.nuc.iblog.entity.Category;
import com.nuc.iblog.entity.CategoryExt;
import com.nuc.iblog.entity.User;
import com.nuc.iblog.service.MSCategoryService;
import com.nuc.iblog.service.MSUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @Author hao
 * @Date 2018/1/11 0:08
 * @Description :后台管理系统用户控制器
 */
@Controller
@RequestMapping("ms")
public class MSUserController {
    Logger log = LoggerFactory.getLogger(MSUserController.class);
    @Autowired
    MSUserService userService;

    @Autowired
    MSCategoryService msCategoryService;

    @RequestMapping("admin-list")
    public ModelAndView adminList(String username) {
        log.info("用户查询条件：" + username);
        ModelAndView modelAndView = userService.adminList(username);
        return modelAndView;
    }

    @RequestMapping("change-password")
    public ModelAndView changePassword(int uid) {
        ModelAndView modelAndView = userService.changePassword(uid);
        return modelAndView;
    }

    @RequestMapping("doChangePassword")
    @ResponseBody
    public Map<String,String> doChangePassword(User user) {
        log.info("修改密码请求，用户id：" + user.getUid() + "密码：" + user.getPassword());
        Map<String, String> map = userService.doChangePassword(user);
        return map;
    }
    @RequestMapping("doChangeAdmin")
    @ResponseBody
    public Map<String,String> doChangeAdmin(@RequestBody Map<String,String> user) {
        log.info("修改权限请求，用户id：" + user.get("uid"));
        Map<String, String> map = userService.doChangeAdmin(user);
        return map;
    }
    @RequestMapping("deleteUser")
    @ResponseBody
    public Map<String,String> deleteUser(@RequestBody Map<String,String> user) {
        log.info("删除用户请求，用户id：" + user.get("uid"));
        Map<String, String> map = userService.deleteUser(user);
        return map;
    }

    @RequestMapping("admin-team-change")
    public ModelAndView adminTeamChange(String uid) {
        log.info("显示修改所属团队页面"+uid);
        ModelAndView modelAndView = new ModelAndView("admin-team-change");
        List<CategoryExt> categoryExts = userService.adminTeamChange(uid);
        modelAndView.addObject("categoryExts", categoryExts);
        modelAndView.addObject("uid", uid);
        return modelAndView;
    }
    @RequestMapping("doAdminTeamChange")
    @ResponseBody
    public Map<String,String>doAdminTeamChange(@RequestParam String uid , @RequestParam String[] catid) {
        log.info("进行所属团队修改操作，uid:"+uid+"catid:"+catid);
        Map<String, String> map = userService.doAdminTeamChange(uid, catid);
        return map;
    }

    @RequestMapping("member-add")
    public ModelAndView memberAdd(String uid) {
        log.info("显示添加教师和学生页面"+uid);
        ModelAndView modelAndView = new ModelAndView("member-add");
        List<Category> categories = msCategoryService.selectAllAcadem();
        modelAndView.addObject("academy", categories);
        return modelAndView;
    }

    @RequestMapping("doMemberAdd")
    @ResponseBody
    public Map<String,String> doMemberAdd(User user) {
        log.info("添加用户操作操作，名字:"+user.getUsername());
        Map<String, String> map = userService.addUser(user);
        return map;
    }
}
