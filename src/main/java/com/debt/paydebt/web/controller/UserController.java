package com.debt.paydebt.web.controller;

import com.debt.paydebt.model.UserDetail;
import com.debt.paydebt.model.UserId;
import com.debt.paydebt.repository.UserIdRepository;
import com.debt.paydebt.repository.UserDetailRepository;
import com.debt.paydebt.service.userservice.UserService;
import com.debt.paydebt.web.form.UserInformationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private UserIdRepository userIdRepository;

    @GetMapping(value = "/aa")
    public String test(Model model){
        UserId x = new UserId("x","b");
        model.addAttribute("userId",x);
        return  "userdetail";
    }

    @PostMapping
    public String login(@RequestBody UserInformationForm form, Model model){
        UserDetail userDetail = userService.login(form);
        return "login";
    }

    @PutMapping
    public String register(@RequestBody UserInformationForm form){
        userService.register(form);
        return "register";
    }

    @PatchMapping("/update/detail")
    public String updateUserDetail(@RequestBody UserInformationForm form){
        userService.updateUserDetail(form);
       return "register";
    }

    @PatchMapping("/update/id")
    public String updateUserPwd(@RequestBody  UserInformationForm form){
        userService.updatePwd(form);
        return "";
    }
}
