package com.debt.paydebt.service.userservice.impl;

import com.debt.paydebt.model.UserDetail;
import com.debt.paydebt.model.UserId;
import com.debt.paydebt.repository.UserDetailRepository;
import com.debt.paydebt.repository.UserIdRepository;
import com.debt.paydebt.service.userservice.UserService;
import com.debt.paydebt.web.form.UserInformationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDetailRepository userDetailRepository;
    @Autowired
    private UserIdRepository userIdRepository;

    @Override
    public UserDetail login(UserInformationForm registerForm) {
        if(userIdRepository.findByIdAndPwd(registerForm.getId(),registerForm.getPwd())!=null){
            return userDetailRepository.findById(registerForm.getId());
        }
        return null;
    }

    @Override
    public UserDetail register(UserInformationForm registerForm) {
        if(userIdRepository.findById(registerForm.getId())!=null){
            return null;
        }else{
            userIdRepository.save(new UserId(registerForm.getId(),registerForm.getPwd()));
            userDetailRepository.save(new UserDetail(
                    registerForm.getId(),
                    registerForm.getFirstName(),
                    registerForm.getLastName(),
                    registerForm.getEmail(),
                    registerForm.getTell()
            ));
            return userDetailRepository.findById(registerForm.getId());
        }
    }

    @Override
    public UserDetail updateUserDetail(UserInformationForm registerForm) {
        return null;
    }

    @Override
    public UserDetail updatePwd(UserInformationForm registerForm) {
        return null;
    }
}
