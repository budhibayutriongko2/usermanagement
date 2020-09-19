package com.usermanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usermanagement.entity.User;


@Repository
@Transactional
public interface UserDAO extends JpaRepository<User,String>{
	User findById(String id);
}
