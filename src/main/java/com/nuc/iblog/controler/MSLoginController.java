package com.nuc.iblog.controler;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.nuc.iblog.entity.User;
import com.nuc.iblog.jpa.UserJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hao
 * @Date 2018/1/9 20:50
 * @Description :后台管理系统登录
 */
@Controller
@RequestMapping("ms")
public class MSLoginController {
    @Autowired
    DefaultKaptcha defaultKaptcha;
    @Autowired
    UserJpa userJpa;
    Logger log = LoggerFactory.getLogger(TestControler.class);

    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            log.info("生成的验证码为：" + createText);
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @ResponseBody
    @RequestMapping("/imgvrifyControllerDefaultKaptcha")
    public Map<String, String> imgvrifyControllerDefaultKaptcha(HttpServletRequest httpServletRequest, @RequestBody Map<String, String> kap) {
        HashMap<String, String> map = new HashMap<String, String>();
        HttpSession session = httpServletRequest.getSession();
        String captchaId = "";
        if (session != null) {
            captchaId = (String) session.getAttribute("vrifyCode");
            log.info("正确验证码： " + captchaId + " 请求验证码 " + kap);

            if (captchaId == null || !captchaId.equalsIgnoreCase(kap.get("kap"))) {
                map.put("code", "0");
            } else {
                map.put("code", "1");
            }
        } else {
            map.put("code", "0");
        }

        return map;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/404")
    public String notFind() {
        return "404";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("userlogin");
        if (user != null) {
            return "index";
        } else {
            return "login";
        }
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public Map<String, String> doLogin(HttpServletRequest httpServletRequest, User user) {
        HashMap<String, String> map = new HashMap<String, String>();
        log.info("登录，用户名：" + user.getUsername() + "密码：" + user.getPassword());
        User byUsernameAndPassword = userJpa.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (byUsernameAndPassword == null) {
            map.put("code", "0");
        } else {
            map.put("code", "1");
            httpServletRequest.getSession().setAttribute("userlogin", byUsernameAndPassword);
        }
        return map;
    }

}
