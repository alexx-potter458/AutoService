package com.potterinc.auto.controller;

import com.potterinc.auto.dao.User;
import com.potterinc.auto.dto.RegisterForm;
import com.potterinc.auto.security.UserSession;
import com.potterinc.auto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    UserSession userSession;

    @GetMapping("/users")
    public ModelAndView getAllUsers() {
        int uid = userSession.getId();
        if(uid == 0) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView usersModel = new ModelAndView("users.html");
        List<User> userList = userService.getAll();

        usersModel.addObject("users", userList);
        return usersModel;
    }

    @GetMapping("/users/{id}")
    public ModelAndView getUserById(@PathVariable Integer id) {
        int uid = userSession.getId();
        if(uid == 0) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView userView = new ModelAndView("userProfile.html");
        User currentUser = userService.getById(id);

        userView.addObject("user", currentUser);
        return userView;
    }


    @PutMapping(value="/users/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView updateUser(@PathVariable Integer id, RegisterForm data) {
        ModelAndView userView = new ModelAndView("userProfile.html");

        System.out.println(id);
        System.out.println(data.getEmail());

        return userView;
    }
}
