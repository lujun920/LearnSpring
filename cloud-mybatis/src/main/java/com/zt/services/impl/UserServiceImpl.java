package com.zt.services.impl;

import com.zt.dao.IUserMapper;
import com.zt.model.User;
import com.zt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p/>类文件: com.zt.services.impl
 * <p/>类功能描述: ${todo}
 *
 * @作者: luj
 * @时间: 2017/4/7 16:34
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User get(User user) {
        return userMapper.get(user);
    }
    @Autowired
    private IUserMapper userMapper;
}
