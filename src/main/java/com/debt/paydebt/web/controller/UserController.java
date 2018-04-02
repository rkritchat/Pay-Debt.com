package com.debt.paydebt.web.controller;

import com.debt.paydebt.model.UserDetail;
import com.debt.paydebt.service.userservice.UserService;
import com.debt.paydebt.web.form.UserInformationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public String login(@ModelAttribute UserInformationForm form, Model model){
        UserDetail userDetail = userService.login(form);
        if(userDetail!=null) {
            model.addAttribute("userDetail", userService.login(form));
            return "userDetail";
        }else{
            model.addAttribute("errorMessage", "Invalid Id or Password");
            return "login";
        }
    }

    @PutMapping
    public String register(@Valid @ModelAttribute UserInformationForm form, Model model){
        model.addAttribute("message","Create user Successfully");
        model.addAttribute("userDetail", userService.register(form));
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
