package com.usermanagement.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Request {
	private User user;
	private List<Object> listUser;
	private String description;
	private String title;
	private String emailContent;
	private String smsContent;
	private String subject;
	private Integer timeout;
	private String phoneNumber;
	private String content;
}
