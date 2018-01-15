package com.nuc.iblog.controler;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.nuc.iblog.entity.User;
import com.nuc.iblog.jpa.UserJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
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

    /**
     * 获取验证码
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
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

    /**
     * 验证验证码
     * @param httpServletRequest
     * @param kap
     * @return
     */
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

    /**
     * 请求页面的通用转发方法
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String login(@PathVariable String page) {
        log.info("请求页面："+page);
        return page;
    }

    @RequestMapping("/404")
    public String notFind() {
        return "404";
    }

    /**
     * 请求首页信息
     * @param request
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("userlogin");
        ModelAndView modelAndView = new ModelAndView();
        if (user != null) {
            Map<String,String> map = System.getenv();
            String username = map.get("USERNAME");//获取用户名
            String computername = map.get("COMPUTERNAME");//获取计算机名
            String serverName = request.getServerName();
            int serverPort = request.getServerPort();
            ServletContext servletContext = request.getServletContext();
            String serverInfo = servletContext.getServerInfo();//服务器的名称和版本
            int majorVersion = servletContext.getMajorVersion();//服务器支持的Servlet主版本号
            int minorVersion = servletContext.getMinorVersion();//服务器支持的Servlet次版本号
            String localAddr = request.getLocalAddr();//取得服务器IP
            int localPort = request.getLocalPort();//取得服务器端口

            String header = request.getHeader("User-Agent");//就是取得客户端的系统版本
            String remoteHost = request.getRemoteHost();//获取客户端主机名
            String remoteAddr = request.getRemoteAddr();//获取客户端IP地址
            int remotePort = request.getRemotePort();//获取客户端端口号
            String protocol = request.getProtocol();//获取客户端请求协议
            String characterEncoding = request.getCharacterEncoding();//获取客户请求的编码方式

            modelAndView.setViewName("index");
            modelAndView.addObject("username",username );
            modelAndView.addObject("computername", computername);
            modelAndView.addObject("serverName", serverName);
            modelAndView.addObject("serverPort",serverPort );
            modelAndView.addObject("serverInfo", serverInfo);
            modelAndView.addObject("majorVersion",majorVersion );
            modelAndView.addObject("minorVersion",minorVersion );
            modelAndView.addObject("remoteHost", remoteHost);
            modelAndView.addObject("remoteAddr", remoteAddr);
            modelAndView.addObject("remotePort", remotePort);
            modelAndView.addObject("protocol", protocol);
            modelAndView.addObject("characterEncoding",characterEncoding );
            modelAndView.addObject("localAddr",localAddr);
            modelAndView.addObject("localPort", localPort);
            modelAndView.addObject("header", header);
            return modelAndView;
//            return "admin-list";
        } else {
            modelAndView.setViewName("login");
//            modelAndView.setViewName("index");
            return modelAndView;
        }
    }

    /**
     * 进行登录操作
     * @param httpServletRequest
     * @param user
     * @return
     */
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

    /**
     * 退出
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/exit")
    @ResponseBody
    public Map<String, String> exit(HttpServletRequest httpServletRequest) {
        HashMap<String, String> map = new HashMap<String, String>();
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("userlogin");
        map.put("code", "1");
        return map;
    }
}
