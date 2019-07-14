package com.lti.paysmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.entities.User;
import com.lti.paysmart.interfaces.UserDao;

@Component
public class UserService {
	
	@Autowired
	UserDao udao;
	
	public String performLogin(UserLoginDTO userLoginDTO) {
		return udao.performLogin(userLoginDTO);
	}

}