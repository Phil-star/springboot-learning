package top.philxin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.philxin.bean.User;
import top.philxin.mapper.UserMapper;
import top.philxin.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUserById(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
