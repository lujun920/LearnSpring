package com.zt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p/>类文件: com.zt.controller
 * <p/>类功能描述: ${todo}
 *
 * @作者: luj
 * @时间: 2017/4/10 16:55
 */
@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://cloud-provider/add?a=10&b=20", String.class).getBody();
    }
}
