package com.nuc.iblog.controler;

import com.nuc.iblog.service.MSSensitiveWordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author hao
 * @Date 2018/1/15 11:16
 * @Description : 敏感词过滤控制器
 */
@Controller
@RequestMapping("ms")
public class MSSensitiveWordController {
    @Autowired
    MSSensitiveWordService msSensitiveWordService;
    Logger log = LoggerFactory.getLogger(MSSensitiveWordController.class);

    @RequestMapping("system-shielding")
    public ModelAndView systemShielding() {
        log.info("访问敏感词设置页面");
        ModelAndView modelAndView = new ModelAndView("system-shielding");
        String s = msSensitiveWordService.readSensitive();
        modelAndView.addObject("SensitiveWord", s);
        return modelAndView;
    }

    @RequestMapping("updateShielding")
    @ResponseBody
    public Map<String, String> updateShielding(String word) {
        log.info("更新敏感词库：" + word);
        Map<String, String> map = msSensitiveWordService.updateSensitiveWord(word);
        return map;
    }
}
