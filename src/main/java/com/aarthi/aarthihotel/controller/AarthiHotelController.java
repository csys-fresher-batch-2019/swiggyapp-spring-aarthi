package com.aarthi.aarthihotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aarthi.aarthihotel.dto.MessagedTo;
import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.model.User;
import com.aarthi.aarthihotel.service.UserService;

@Controller
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class AarthiHotelController {
	UserService user=new UserService();
	
	@PostMapping("/addloginregister")
	public MessagedTo addloginregister(@RequestParam("name") String name,
			@RequestParam("phoneno") Long phoneno) throws DbException {
		MessagedTo message=new MessagedTo();
		User ob=new User();
		ob.setUserName(name);
		ob.setPhoneNo(phoneno);
		String a=user.login(name, phoneno);
		if(a.equals("Welcome "+name))
		{
			message.setInfoMessage("register success");
		}else
		{
			message.setErrorMessage("register failed");
		}
		return message;
		
	}
	}

