package com.debt.paydebt.repository;

import com.debt.paydebt.model.UserDetail;
import com.debt.paydebt.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserDetailRepository extends JpaRepository<UserDetail,Long> {
    UserDetail findById(String id);
}
