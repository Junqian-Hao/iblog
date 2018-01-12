package com.nuc.iblog.service.imp;

import com.nuc.iblog.entity.User;
import com.nuc.iblog.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hao
 * @Date 2018/1/12 12:28
 * @Description :
 */
@Service
public class MSLoginServiceImp implements com.nuc.iblog.service.MSLoginService {
    @Autowired
    UserJpa userJpa;

    @Override
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

    @Override
    public Map<String, String> doLogin(HttpServletRequest httpServletRequest,User user) {
        HashMap<String, String> map = new HashMap<String, String>();
        User byUsernameAndPassword = userJpa.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (byUsernameAndPassword == null) {
            map.put("code", "0");
        } else {
            map.put("code", "1");
            httpServletRequest.getSession().setAttribute("userlogin", byUsernameAndPassword);
        }
        return map;
    }

    @Override
    public Map<String, String> exit(HttpServletRequest httpServletRequest) {
        HashMap<String, String> map = new HashMap<String, String>();
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("userlogin");
        map.put("code", "1");
        return map;
    }
}
