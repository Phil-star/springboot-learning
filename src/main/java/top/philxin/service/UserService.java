package top.philxin.service;

import org.springframework.web.multipart.MultipartFile;
import top.philxin.bean.User;
import top.philxin.bean.Users;
import top.philxin.exception.AccountException;
import top.philxin.exception.UnknownAccountException;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    User selectUserById(int id);

    void queryUserExist(Users user) throws UnknownAccountException, AccountException;

    Users addNewUser(Users user, MultipartFile image, HttpServletRequest request) throws UnknownAccountException, AccountException;
}
