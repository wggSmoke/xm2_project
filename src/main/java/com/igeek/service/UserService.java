package com.igeek.service;

import com.igeek.dao.DepDao;
import com.igeek.dao.UserDao;
import com.igeek.pojo.Dep;
import com.igeek.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
@Autowired
private UserDao userDao;

private DepDao depDao;

@Transactional
public User findUserByName(String userName)
{
    return userDao.findByName(userName);
}


@Transactional
public List<Dep> findAllDep(){

    List<Dep> list=depDao.findAllDep();

    return list;
}

}
