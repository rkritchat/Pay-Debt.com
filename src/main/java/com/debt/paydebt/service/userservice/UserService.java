package com.debt.paydebt.service.userservice;

import com.debt.paydebt.web.form.UserInformationForm;
import com.debt.paydebt.model.UserDetail;

public interface UserService {
    UserDetail login(UserInformationForm registerForm);
    UserDetail register(UserInformationForm registerForm);
    UserDetail updateUserDetail(UserInformationForm registerForm);
    UserDetail updatePwd(UserInformationForm registerForm);
}
