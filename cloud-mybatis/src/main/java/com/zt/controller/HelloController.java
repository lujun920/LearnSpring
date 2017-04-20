package com.zt.controller;

import com.zt.model.User;
import com.zt.services.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p/>类文件: com.zt.controller
 * <p/>类功能描述: ${todo}
 *
 * @作者: luj
 * @时间: 2017/4/10 10:57
 */
@Controller
@MapperScan("com.zt.dao")
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping(value="/getbean/{id}", method= RequestMethod.GET)
    public @ResponseBody User getBean(@PathVariable Integer id){
        User u= new User();
        u.setUserId(id);
        u=userService.getBean(u);
        logger.info("777************************************************");
        return u;
    }
    @Autowired
    private UserService userService;
}
