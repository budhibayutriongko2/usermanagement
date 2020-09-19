package com.usermanagement.service;

import com.usermanagement.dto.FirebaseResponse;
import com.usermanagement.dto.Request;
import com.usermanagement.entity.User;

public interface UserService {
	void register (User request) throws Exception;
	void update (User request) throws Exception;
	User view (User request) throws Exception;
	
}
