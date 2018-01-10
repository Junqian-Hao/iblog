package com.nuc.iblog.controler;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

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
    Logger log = LoggerFactory.getLogger(TestControler.class);
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        String realPath = httpServletRequest.getSession().getServletContext().getRealPath("");
        log.info("系统的路径"+realPath);
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            log.info("生成的验证码为："+createText);
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

    @RequestMapping("/imgvrifyControllerDefaultKaptcha")
    public ModelAndView imgvrifyControllerDefaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        ModelAndView andView = new ModelAndView();
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        String parameter = httpServletRequest.getParameter("vrifyCode");
        System.out.println("正确验证码： "+captchaId+" 请求验证码 "+parameter);

        if (!captchaId.equalsIgnoreCase(parameter)) {
            andView.addObject("info", "错误的验证码");
            andView.setViewName("index");
        } else {
            andView.addObject("info", "登录成功");
            andView.setViewName("succeed");

        }
        return andView;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/404")
    public String notFind() {
        return "404";
    }
}
