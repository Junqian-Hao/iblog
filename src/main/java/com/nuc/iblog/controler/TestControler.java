package com.nuc.iblog.controler;


import com.nuc.iblog.entity.Article;
import com.nuc.iblog.jpa.ArticleJpa;
import com.nuc.iblog.jpa.UserJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;

/**
 * @Author hao
 * @Date 2018/1/8 19:23
 * @Description :
 */
@Controller
@RequestMapping
public class TestControler {
    @Autowired
    ArticleJpa articleJpa;
    @Autowired
    UserJpa userJpa;
    Logger log = LoggerFactory.getLogger(TestControler.class);
    @RequestMapping("/")
    public String index() {
        return "hello";
    }
    @ResponseBody
    @RequestMapping("/jpa")
    public String  jpa() {
//        List<Article> byAid = articleJpa.findByAid(6);
//        log.debug("文章持久层操作：" + byAid);
//        List<Category> all1 = categoryJpa.findAll();
//        log.debug("分类持久层操作："+all1);
//        List<Comments> all2 = commentsJpa.findAll();
//        log.debug("评论持久层操作：" + all2);
//        List<User> all3 = userJap.findAll();
//        log.debug("用户持久层操作："+all3);
//        Article article = byAid.get(0);
//        for (int i= 0 ; i<10;i++) {
//            User user = new User();
//            user.setIsAdmin((new Random().nextInt()%2));
//            user.setUsername(getRandomString(5));
//            user.setPassword(new Random(9).nextInt()+new Random(9).nextInt(9)+new Random().nextInt(9)+"");
//            userJpa.save(user);
//        }
        List<Article> 张鑫 = articleJpa.selecrArticle("张鑫");
        return "success";
    }

    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
