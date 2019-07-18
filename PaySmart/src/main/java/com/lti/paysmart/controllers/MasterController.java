package com.lti.paysmart.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.paysmart.dto.AddProductDTO;
import com.lti.paysmart.dto.AdminLoginDTO;
import com.lti.paysmart.dto.LoginResponseDTO;
import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.dto.UserRegisterDTO;
import com.lti.paysmart.dto.ViewUsersAdminDTO;
import com.lti.paysmart.entities.User;
import com.lti.paysmart.interfaces.AdminService;
import com.lti.paysmart.interfaces.UserService;

@RestController
public class MasterController {
	
	@Autowired
	UserService userServ;

	@Autowired
	AdminService admServ;
	
	@RequestMapping(value = "/login.user", method = RequestMethod.POST)
	public LoginResponseDTO login(@RequestBody UserLoginDTO userLoginDTO) {
		
		LoginResponseDTO response = new LoginResponseDTO();
		String result = userServ.performLogin(userLoginDTO);
		if(result.equals("User account does not exist!")) {
			response.setMessage("User account does not exist!");
			return response;
		}
		else if(result.equals("Success")) {
			response.setPassword(userLoginDTO.getPassword());
			response.setUsername(userLoginDTO.getUsername());
			response.setMessage("Success");
			return response;
		}
		else {
			response.setMessage("Incorrect Password");
			return response;
		}
	}
	
	@RequestMapping(value = "/login.admin", method = RequestMethod.POST)
	public LoginResponseDTO login(@RequestBody AdminLoginDTO adminLoginDTO) {
		
		LoginResponseDTO response = new LoginResponseDTO();
		String result = admServ.performLogin(adminLoginDTO);
		if(result.equals("Administrator account does not exist!")) {
			response.setMessage("User does not exist");
			return response;
		}
		else if(result.equals("Success")) {
			response.setPassword(adminLoginDTO.getPassword());
			response.setUsername(adminLoginDTO.getUsername());
			response.setMessage("Success");
			return response;
		}
		else {
			response.setMessage("Incorrect Password");
			return response;
		}
		
	}
	
	@RequestMapping(value = "/register.user", method = RequestMethod.POST)
	public String register(UserRegisterDTO userRegisterDTO) {
		return userServ.performRegister(userRegisterDTO);
	}
	
	@RequestMapping(value = "/add.product", method = RequestMethod.POST)
	public String addProduct(AddProductDTO addProductDTO) {
		return admServ.addProduct(addProductDTO);
	}
	
	@RequestMapping(value = "/view.all.users", method = RequestMethod.POST)
	public List<ViewUsersAdminDTO> viewUserDetails() {
		List<User> list = admServ.viewAllUser();
		List<ViewUsersAdminDTO> responseList = new ArrayList<ViewUsersAdminDTO>();
		ViewUsersAdminDTO object = new ViewUsersAdminDTO();
		for(User user_iterator:list) {
			object.setFname(user_iterator.getFname());
			object.setLname(user_iterator.getLname());
			object.setEmail(user_iterator.getEmail());
			object.setPhone_no(user_iterator.getPhone_no());
			object.setAddress(user_iterator.getAddress().getDoorNo()+", "+user_iterator.getAddress().getStreet()+", "+user_iterator.getAddress().getCity());
			object.setAadharfile(user_iterator.getDocument().getAadharcardfilename());
			object.setPanfile(user_iterator.getDocument().getPancardfilename());
			responseList.add(object);
		}
		return responseList;
	}
}
