package com.zt.controller;

import com.zt.model.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
 * @时间: 2017/4/5 16:09
 */
@RestController
@RequestMapping(value="/hello")
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    private  List<Map<String, String>> listMap= new ArrayList<Map<String, String>>();

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public List<Map<String, String>> getList(){
        Map<String, String> map1= new HashMap<String, String>();
        Map<String, String> map2= new HashMap<String, String>();
        Map<String, String> map3= new HashMap<String, String>();

        map1.put("aaa", "111");
        map1.put("bbb", "222");
        map1.put("ccc", "333");
        listMap.add(map1);

        map2.put("ddd", "444");
        map2.put("eee", "555");
        map2.put("fff", "666");
        listMap.add(map2);

        map3.put("ggg", "777");
        map3.put("hhh", "888");
        map3.put("iii", "999");
        listMap.add(map3);
        return listMap;
    }
    @RequestMapping(value="/save", method= RequestMethod.POST)
    public void save(@ModelAttribute Demo bean){
        logger.info("id:{} name:{} age:{} context:{}", bean.getId(), bean.getName(), bean.getAge(), bean.getContext());
    }

    @RequestMapping(value="/getbean/{id}", method= RequestMethod.GET)
    public Demo getBean(@PathVariable Integer id){
        Demo d= new Demo();
        d.setId(id);
        d.setAge(25);
        d.setName("bilibili");
        d.setContext("456789");
        return d;
    }

    @RequestMapping(value="/del/{id}", method= RequestMethod.DELETE)
    public void deleteBean(@PathVariable Integer id){
        logger.info("delete id: {}", id);
    }



}
