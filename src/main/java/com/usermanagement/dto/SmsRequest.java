package com.usermanagement.dto;

/**
 * Created by Dinda.Wahyudi06 on 11/18/2016.
 */
public class SmsRequest {

    private String phoneNumber;
    private String content;
    private String contractNumber;

    public SmsRequest() {
    }

    public SmsRequest(String phoneNumber, String content, String contractNumber) {
        this.phoneNumber = phoneNumber;
        this.content = content;
        this.contractNumber = contractNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }
}
