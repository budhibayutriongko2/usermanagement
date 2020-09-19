package com.usermanagement.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usermanagement.constant.GENERAL_CONSTANT;
import com.usermanagement.dto.Request;
import com.usermanagement.dto.Response;
import com.usermanagement.entity.User;
import com.usermanagement.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/")
public class UserController {

    @Autowired
    private UserService userService;

 
    ObjectMapper mapper = new ObjectMapper();


    @PostMapping(value = "${api.register}") 
    public ResponseEntity<Response> register(@RequestBody User request) throws Exception{
        Response tippersResponse = new Response();
        try {
        	userService.register(request);
            tippersResponse.setCode("00");
            tippersResponse.setDescription(GENERAL_CONSTANT.SUCCESS);
            tippersResponse.setObject(null);
        }catch (Exception e){
            tippersResponse.setCode("01");
            tippersResponse.setDescription(GENERAL_CONSTANT.FAILED);
            tippersResponse.setObject(e.getMessage());
        }
        return new ResponseEntity<>(tippersResponse, HttpStatus.OK);
    }

    @PostMapping(value = "${api.update}") 
    public ResponseEntity<Response> Update(@RequestBody User request) throws Exception{
        Response tippersResponse = new Response();
        try {
        	userService.update(request);
            tippersResponse.setCode("00");
            tippersResponse.setDescription(GENERAL_CONSTANT.SUCCESS);
            tippersResponse.setObject(null);
        }catch (Exception e){
            tippersResponse.setCode("01");
            tippersResponse.setDescription(GENERAL_CONSTANT.FAILED);
            tippersResponse.setObject(e.getMessage());
        }
        return new ResponseEntity<>(tippersResponse, HttpStatus.OK);
    }

    
    @PostMapping(value = "${api.view}") 
    public ResponseEntity<Response> view(@RequestBody User request) throws Exception{
        Response tippersResponse = new Response();
        try {
        	User user = userService.view(request);
            tippersResponse.setCode("00");
            tippersResponse.setDescription(GENERAL_CONSTANT.SUCCESS);
            tippersResponse.setObject(null);
        }catch (Exception e){
            tippersResponse.setCode("01");
            tippersResponse.setDescription(GENERAL_CONSTANT.FAILED);
            tippersResponse.setObject(e.getMessage());
        }
        return new ResponseEntity<>(tippersResponse, HttpStatus.OK);
    }
   
}
