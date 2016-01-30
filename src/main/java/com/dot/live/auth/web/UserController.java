package com.dot.live.auth.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dot.live.auth.domain.User;
import com.dot.live.auth.service.IUserService;


@RestController 
@RequestMapping("/authUser")
public class UserController {
	
	@Autowired
	IUserService userService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED) 
	public void save(@Valid @RequestBody User user){
		userService.save(user);
    }
	
	@RequestMapping(value = "/name/{username}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK) 
	public User name(@PathVariable String username){
		Assert.hasLength(username);
		return userService.getUserByName(username);
    }

}
