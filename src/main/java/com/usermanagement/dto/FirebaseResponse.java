package com.usermanagement.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by ronaldo.rindorindo on 10/8/2019
 **/
@Data
public class FirebaseResponse {
    private Long multicast_id;
    private Integer success;
    private Integer failure;
    private Integer canonical_ids;
    private List<Object> results;
}
