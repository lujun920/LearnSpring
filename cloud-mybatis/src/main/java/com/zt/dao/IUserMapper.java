package com.zt.dao;

import com.zt.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p/>类文件: com.zt.dao
 * <p/>类功能描述: ${todo}
 *
 * @作者: luj
 * @时间: 2017/4/7 16:13
 */
@Mapper
public interface IUserMapper {
    User get(User user);
}
