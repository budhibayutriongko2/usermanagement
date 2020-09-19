package com.usermanagement.dto;

import lombok.Data;




import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class User {
    private String id;
    private String username;
    private String pass;
    private String email;
    private String phoneNumber;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    private String isDelete;
    private String firstName;
    private String lastName;
    private String employeeCode;
    private String partnerStatus;
    private String ktpNumber;
    private String npwpNumber;
    private String bankCode;
    private String npwpAddress;
    private String accountNumber;
    private String accountName;
    private String promotor;
    private String isSelfRegrist;
    private String tippersStatus;

    @PrePersist
    protected void onCreate() {
        createdDate = new Timestamp(new Date().getTime());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = new Timestamp(new Date().getTime());
    }
}
