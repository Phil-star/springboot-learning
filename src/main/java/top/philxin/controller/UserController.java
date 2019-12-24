package top.philxin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import top.philxin.bean.User;
import top.philxin.service.UserService;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("user/register")
    public User userRegister() {
        User user = userService.selectUserById(2);
        return user;
    }
}
