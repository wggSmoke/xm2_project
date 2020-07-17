package com.igeek.dao;

import com.igeek.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    public User findByName(String name);
}
