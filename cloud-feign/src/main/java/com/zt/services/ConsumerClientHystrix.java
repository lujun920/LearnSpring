package com.zt.services;

import com.zt.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p/>类文件: com.zt.services
 * <p/>类功能描述: ${todo}
 *
 * @作者: luj
 * @时间: 2017/4/11 17:13
 */
@Component
public class ConsumerClientHystrix implements ConsumerClient {
    @Override
    public List<Map<String, String>> add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        List<Map<String, String>> listMap= new ArrayList<Map<String, String>>();
        Map<String, String> map= new HashMap<String, String>();
        map.put("errorCode", "0001");
        listMap.add(map);
        return listMap;
    }

    @Override
    public User save(@ModelAttribute("user") User user) {
        return null;
    }

}
