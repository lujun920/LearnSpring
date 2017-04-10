package com.zt;

import com.zt.model.User;
import com.zt.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p/>类文件: com.zt
 * <p/>类功能描述: ${todo}
 *
 * @作者: luj
 * @时间: 2017/4/7 16:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class ApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void findByName() throws Exception {
        User u = new User();
        u.setUserId(1);
        u = userService.get(u);
        System.out.println("username: "+u.getUserName());
    }
}
