package com.usermanagement.service.impl;


import com.usermanagement.config.EndpointConfig;
import com.usermanagement.config.GeneralConfig;
import com.usermanagement.constant.GENERAL_CONSTANT;
import com.usermanagement.dao.UserDAO;
import com.usermanagement.dto.*;
import com.usermanagement.entity.User;
import com.usermanagement.service.UserService;
import com.usermanagement.utility.ConnectorUtil;
import com.usermanagement.utility.HeaderRequestInterceptor;
import com.usermanagement.utility.HelperUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.net.*;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl implements UserService {

	private static final String API = "api/";
	private static final Logger log = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	GeneralConfig generalConfig;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	UserDAO userDao;
	


	@Override
	public void register (User request) throws Exception {
		userDao.save(request);
	}
	
	@Override
	public void update (User request) throws Exception {
		User user = userDao.findById(request.getId());
		userDao.save(request);
	}
	
	
	@Override
	public User view (User request) throws Exception {
		return  userDao.findById(request.getId());
		
	}
	
}
