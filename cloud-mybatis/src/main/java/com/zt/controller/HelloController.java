package com.zt.controller;

import com.zt.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p/>类文件: com.zt.controller
 * <p/>类功能描述: ${todo}
 *
 * @作者: luj
 * @时间: 2017/4/10 10:57
 */
@Controller
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping(value="/getbean/{id}", method= RequestMethod.GET)
    public User getBean(@PathVariable Integer id){
        User u= new User();
        return u;
    }
}
