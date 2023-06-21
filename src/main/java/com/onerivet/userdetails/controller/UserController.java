	package com.onerivet.userdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.userdetails.models.payloads.AuthRequest;
import com.onerivet.userdetails.models.payloads.UserDto;
import com.onerivet.userdetails.services.JwtServices;
import com.onerivet.userdetails.services.UserServices;

import jakarta.validation.Valid;

@Valid
@RestController
@RequestMapping("/userdetails")
public class UserController {
	
	@Autowired private UserServices userServices;
	
	@Autowired private AuthenticationManager authenticationManager;
	
    @Autowired
    private JwtServices jwtService;
	
	@PostMapping("/add-user")
	public String add(@RequestBody UserDto userDto ) {
		return userServices.addUser(userDto);
	}
	
	@GetMapping("/get-user")
	public List<UserDto> getUser(){
		return userServices.getAllUser();
	}
	
	@GetMapping("/get-user/{id}")
	public UserDto getUser(@PathVariable int id){
		return userServices.getUserById(id);
	}
	
	@PutMapping("/update/{id}")
	public String update(@RequestBody UserDto userDto ,@PathVariable   int id) {
		return userServices.updateById(userDto, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return userServices.deleteById(id);
	}
	
	@PostMapping("/authenticate")

	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
	Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

	if(authentication.isAuthenticated()) {

	return jwtService.generateToken(authRequest.getUsername());

	}

	else {

	throw new UsernameNotFoundException("Invalid user Request");

	}

	// return jwtService.generateToken(authRequest.getEmail());

	}
	
}
