package top.philxin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import top.philxin.bean.User;
import top.philxin.bean.Users;
import top.philxin.exception.UnknownAccountException;
import top.philxin.service.UserService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("user/register")
    public ModelAndView userRegister(Users user, MultipartFile image, HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        userService.queryUserExist(user);
        Users newUser = userService.addNewUser(user, image, request);
        modelAndView.setViewName("userInfo");
        modelAndView.addObject("username",newUser.getName());
        modelAndView.addObject("account",user.getAccount());
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        System.out.println(newUser.getImage_url());
        modelAndView.addObject("avatar",realPath + newUser.getImage_url());
        return modelAndView;
    }
}
