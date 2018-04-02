package com.debt.paydebt.service.userservice.impl;

import com.debt.paydebt.model.UserDetail;
import com.debt.paydebt.model.UserId;
import com.debt.paydebt.repository.UserDetailRepository;
import com.debt.paydebt.repository.UserIdRepository;
import com.debt.paydebt.service.userservice.UserService;
import com.debt.paydebt.web.form.UserInformationForm;
import org.springframework.beans.factory.annotation.Autowired;
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
            saveUserId(registerForm);
            saveUserDetail(registerForm);
            return userDetailRepository.findById(registerForm.getId());
        }
    }

    @Override
    public UserDetail updateUserDetail(UserInformationForm registerForm) {
        if(!isValidIdAndPwd(registerForm.getId(),registerForm.getPwd())){
            return null;
        }else{
            saveUserDetail(registerForm);
            return userDetailRepository.findById(registerForm.getId());
        }
    }

    @Override
    public UserDetail updatePwd(UserInformationForm registerForm) {
        if(!isValidIdAndPwd(registerForm.getId(),registerForm.getPwd())){
            return null;
        }else{
            userIdRepository.save(new UserId(registerForm.getId(),registerForm.getPwd()));
            return userDetailRepository.findById(registerForm.getId());
        }
    }

    private void saveUserDetail(UserInformationForm registerForm){
        userDetailRepository.save(new UserDetail(
                registerForm.getId(),
                registerForm.getFirstName(),
                registerForm.getLastName(),
                registerForm.getEmail(),
                registerForm.getTell()
        ));
    }

    private void saveUserId(UserInformationForm registerForm){
        userIdRepository.save(new UserId(registerForm.getId(),registerForm.getPwd()));
    }

    public boolean isValidIdAndPwd(String id, String pwd) {
        if (userIdRepository.findByIdAndPwd(id, pwd) == null) {
            return true;
        }
        return false;
    }
}
