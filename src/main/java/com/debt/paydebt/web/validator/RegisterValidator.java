package com.debt.paydebt.web.validator;

import com.debt.paydebt.web.form.UserInformationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegisterValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return UserInformationForm.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserInformationForm form = (UserInformationForm) target;
        if(!form.getPwd().equals(form.getRePwd())){
            errors.rejectValue("pwd",null,"Password not same as re-password");
            errors.rejectValue("rePwd",null,"Re-password not sane as password");
        }
    }
}
