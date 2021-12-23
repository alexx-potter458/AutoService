package com.potterinc.auto.controller;

import com.potterinc.auto.dto.LoginForm;
import com.potterinc.auto.dto.RegisterForm;
import com.potterinc.auto.dao.User;
import com.potterinc.auto.security.UserSession;
import com.potterinc.auto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserSession userSession;

    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("register.html");
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login.html");
    }

    @PostMapping(value = "/register-result", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView postRegister(RegisterForm data) {

        ModelAndView registerView = new ModelAndView("register.html");
        boolean wasAdded = userService.add(data);

        if(wasAdded) {
            return new ModelAndView("redirect:/login");
        } else {
            registerView.addObject("errEmail", "Can't add user");
        }

        return registerView;
    }

    @PostMapping(value="/login-result", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView postLogin(LoginForm data) {
        ModelAndView loginView = new ModelAndView("login.html");

        User user = userService.getByEmailAndPassword(data.getEmail(), data.getPassword());



        if(user == null){
            loginView.addObject("errLogin", "Incorrect email or password");
        } else {
            userSession.setId(user.getId());
            return new ModelAndView("redirect:/dashboard");
        }

        return loginView;
    }
}
