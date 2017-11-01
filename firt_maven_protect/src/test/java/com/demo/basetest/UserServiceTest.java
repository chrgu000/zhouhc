package com.demo.basetest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.entity.User;
import com.demo.service.UserService;

public class UserServiceTest  extends SpringTestCase {
	   @Autowired 
	    private UserService userService; 

	    @Test 
	    public void selectUserByIdTest(){  

	        User user = userService.selectUserById(1);  

	        System.out.println(user.getUserName() + ":" + user.getUserPassword());

	    }  


}
