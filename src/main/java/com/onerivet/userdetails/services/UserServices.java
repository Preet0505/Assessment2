package com.onerivet.userdetails.services;

import java.util.List;

import com.onerivet.userdetails.models.payloads.UserDto;

public interface UserServices {

	String addUser(UserDto userDto);

	List<UserDto> getAllUser();
	
	UserDto getUserById(int id);
	
	String updateById(UserDto userDto,int id);
	
	String deleteById(int id);

}
