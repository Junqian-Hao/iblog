package com.nuc.iblog.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by Tyranitarx on 2018/1/11.
 *
 * @Description :
 */
@Controller
@RequestMapping("cl")
public class ClWriteController {
    Logger log = LoggerFactory.getLogger(ClWriteController.class);
    @RequestMapping("/writeArticle")
    public String toWritePage(){
        return "write";
    }
    @RequestMapping("/writeSubmit")
    public String WriteAndtoSelfBlog(@RequestParam String content){

        return "/cl/selfblog";
    }
}
