package com.usermanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by ronaldo.rindorindo on 10/8/2019
 **/
@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FirebaseSpecificOrIncentive {
    private List<String> registration_ids;
    private Notification notification;
    private String priority;
    private Data data;
    private Apns apns;
    private Android android;
}
