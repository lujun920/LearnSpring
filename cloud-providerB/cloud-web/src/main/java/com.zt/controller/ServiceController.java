package com.zt.controller;

import com.zt.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p/>类文件: com.zt.controller
 * <p/>类功能描述: ${todo}
 *
 * @作者: luj
 * @时间: 2017/4/10 16:26
 */
@RestController
public class ServiceController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public List<Map<String, String>> add(@RequestParam Integer a, @RequestParam Integer b) {
        logger.info("service B....");
        ServiceInstance instance = client.getLocalServiceInstance();
        List<Map<String, String>> listMap= new ArrayList<Map<String, String>>();
        long startTime= System.currentTimeMillis();
        for(int i = 0; i < a; i++) {
            Map<String, String> map= new HashMap<String, String>();
            map.put("map"+i, "value value value value value value value value value value value");
            listMap.add(map);
        }
        long endTime= System.currentTimeMillis();
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + a+" array: "+(endTime-startTime));
        return listMap;
    }

    @RequestMapping(value = "/save" ,method = RequestMethod.POST)
    public User save(@ModelAttribute("user")  User user) {
        user.setName("reName");
        return user;
    }

}
