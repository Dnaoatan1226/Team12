package com.Team12.logindemo.service.serviceImpl;

import com.Team12.logindemo.repository.UserDao;
import com.Team12.logindemo.service.UserService;
import com.Team12.logindemo.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User loginService(String uname, String password) {
        // 如果账号密码都对则返回登录的用户对象，若有一个错误则返回null
        User user = userDao.findByUnameAndPassword(uname, password);
        return user;
    }
    @Override
    public User registService(User user) {
        //当新用户用户名已存在时
        if(userDao.findByUname(user.getUname())!=null){
            // 无法注册
            return null;
        }
        else{
            //返回创建好的用户对象
            User newUser = userDao.save(user);
            return newUser;
        }
    }
}