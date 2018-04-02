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

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private UserIdRepository userIdRepository;

    @PostMapping
    public String login(@RequestBody UserInformationForm form, Model model){
        UserDetail userDetail = userService.login(form);
        return "login";
    }

    @PutMapping
    public String register(@RequestBody UserInformationForm form){
        userService.register(form);
        return "";
    }

    @PatchMapping("/detail")
    public ResponseEntity updateUserDetail(@RequestBody UserDetail userDetail){
        if(!isValidIdAndPwd(userDetail.getUserId().getId(),userDetail.getUserId().getPwd())){
            return new ResponseEntity<Object>("Invalid User or Password",HttpStatus.OK);
        }else{
            userDetailRepository.save(userDetail);
            return new ResponseEntity<Object>("Update User detail Successfully",HttpStatus.OK);
        }
    }

    @PatchMapping("/id")
    public ResponseEntity updateUserPwd(@RequestBody UserId userId){
        if(!isValidIdAndPwd(userId.getId(),userId.getPwd())) {
            return new ResponseEntity<Object>("Invalid User or Password",HttpStatus.OK);
        }else{
            userIdRepository.save(userId);
            return new ResponseEntity<Object>("Update Password Successfully",HttpStatus.OK);
        }
    }

    public boolean isValidIdAndPwd(String id, String pwd) {
        if (userIdRepository.findByIdAndPwd(id, pwd) == null) {
            return true;
        }
        return false;
    }
}
