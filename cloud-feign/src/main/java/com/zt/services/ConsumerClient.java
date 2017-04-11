package com.zt.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * <p/>类文件: com.zt.services
 * <p/>类功能描述: ${todo}
 *
 * @作者: luj
 * @时间: 2017/4/11 15:31
 */
@FeignClient(value= "cloud-provider", fallback= ConsumerClientHystrix.class)
public interface ConsumerClient {
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    List<Map<String, String>> add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
