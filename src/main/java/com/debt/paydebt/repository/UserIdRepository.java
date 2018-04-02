package com.debt.paydebt.repository;

import com.debt.paydebt.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserIdRepository extends JpaRepository<UserId, Long> {
    UserId findByIdAndPwd(String id, String pwd);
    UserId findById(String id);
}
