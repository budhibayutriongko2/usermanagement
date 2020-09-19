package com.usermanagement.dto;


import lombok.Data;




@Data
public class Response {
    
    private String auth;

    
    private String token;

    
    private Long timestamp;

    
    private String code;

    
    private Object object;

   
    private String description;

    private String severity;

    private String message;

    public Long getTimestamp() {
        timestamp = System.currentTimeMillis();
        return timestamp;
    }
}
