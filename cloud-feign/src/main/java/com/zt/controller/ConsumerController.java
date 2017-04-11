package com.zt.controller;

import com.zt.services.ConsumerClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p/>类文件: com.zt.controller
 * <p/>类功能描述: ${todo}
 *
 * @作者: luj
 * @时间: 2017/4/11 15:37
 */
@RestController
public class ConsumerController {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);
    @Autowired
    ConsumerClient consumerClient;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        long startTime= System.currentTimeMillis();
        List<Map<String, String>> listMap= consumerClient.add(100000, 20);
        long endTime= System.currentTimeMillis();
        logger.info("响应时间: {}ms", (endTime-startTime));
        return "返回数据总数: "+listMap.size()+" 响应时间: "+(endTime-startTime)+"ms"+" value: "+ listMap.get(0);
    }
}
