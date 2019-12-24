package top.philxin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.philxin.bean.User;
import top.philxin.bean.Users;
import top.philxin.exception.AccountException;
import top.philxin.exception.UnknownAccountException;
import top.philxin.mapper.UserMapper;
import top.philxin.mapper.UsersMapper;
import top.philxin.service.UserService;
import top.philxin.util.FileUploadUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    FileUploadUtils fileUploadUtils;

    @Override
    public User selectUserById(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public void queryUserExist(Users user) throws AccountException {
        Integer integer = usersMapper.selectUserByAccount(user.getAccount());
        if(integer != 0) {
            throw new AccountException(user.getAccount() + "已经存在");
        }
    }

    @Override
    public Users addNewUser(Users user, MultipartFile image, HttpServletRequest request) throws AccountException {
        String fileUrl = null;
        try {
            fileUrl = fileUploadUtils.processUploadFile(request, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setImage_url(fileUrl);
        Integer integer = usersMapper.insertNewUser(user);
        if(integer != 1) {
            throw new AccountException("xxxx");
        }
        return user;
    }
}
