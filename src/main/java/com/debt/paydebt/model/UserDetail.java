package com.debt.paydebt.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user_detail")
public class UserDetail {
    @Id
    @NotEmpty
    private String id;
    @Column(name="first_name")
    @NotEmpty
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String tell;

    @Transient
    @OneToOne
    @JoinColumn(name = "id")
    private UserId userId;

    public UserDetail(){}

    public UserDetail(@NotEmpty String id, @NotEmpty String firstName, String lastName, String email, String tell) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tell = tell;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }
}
