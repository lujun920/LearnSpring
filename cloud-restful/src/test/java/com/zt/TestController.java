package com.zt;

import com.zt.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.equalTo;

/**
 * <p/>类文件: com.zt
 * <p/>类功能描述: ${todo}
 *
 * @作者: luj
 * @时间: 2017/4/5 17:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class TestController {
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void testController() throws Exception {
        RequestBuilder request = null;
        request = get("/hello/list");
        mvc.perform(request)        //执行请求
                .andExpect(status().isOk()) //验证http状态码
                .andDo(print());
    }

    @Test
    public void saveController() throws Exception {
        RequestBuilder request = null;
        request = post("/hello/save")
        .param("id", "1").param("age", "20").param("name", "niconico").param("context", "123456");
        mvc.perform(request)        //执行请求
                .andExpect(status().isOk()) //验证http状态码
                .andDo(print());
    }

    @Test
    public void getController() throws Exception {
        RequestBuilder request = null;
        request = get("/hello/getbean/1");
        mvc.perform(request)        //执行请求
                .andExpect(status().isOk()) //验证http状态码
                .andDo(print());
    }

    @Test
    public void deleteController() throws Exception {
        RequestBuilder request = null;
        request = delete("/hello/del/1");
        mvc.perform(request)        //执行请求
                .andExpect(status().isOk()) //验证http状态码
                .andDo(print());
    }

    @Test
    public void testUrlController() throws Exception {
        RequestBuilder request = null;
        request = delete("/hello/test/1");
        mvc.perform(request)        //执行请求
                .andDo(print())
                .andExpect(status().isNotFound()) //验证控制器不存在
                .andReturn();
    }
}
