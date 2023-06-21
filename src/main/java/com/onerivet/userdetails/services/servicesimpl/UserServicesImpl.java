package com.onerivet.userdetails.services.servicesimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.onerivet.userdetails.exception.ResourceNotFoundException;
import com.onerivet.userdetails.models.entity.User;
import com.onerivet.userdetails.models.payloads.UserDto;
import com.onerivet.userdetails.repository.UserRepository;
import com.onerivet.userdetails.services.UserServices;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	@Override
	public String addUser(@RequestBody UserDto userDto) {
		
		userDto.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
		
		User user = userDtoToUser(userDto);
		userRepository.save(user);
		return "User added Succesfully";
	}


	@Override
	public List<UserDto> getAllUser() {
		return userRepository.findAll().stream().map(getUser -> modelMapper.map(getUser, UserDto.class)).collect(Collectors.toList());
	}
	

	@Override
	public UserDto getUserById(int id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		UserDto userDto = this. modelMapper.map(user, UserDto.class);
		return userDto;
	}


	@Override
	public String updateById(UserDto userDto, int id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		if(user == null) {
			return "Please enter valid id";
		}
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setUserName(userDto.getUserName());
		user.setPhoneNo(userDto.getPhoneNo());
		user.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
		userRepository.save(user);
		return "User Updated successfully";
	}


	@Override
	public String deleteById(int id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		if(user==null) {
			return "Enter valid id";
		}
		userRepository.deleteById(id);
		return "Deleted Successfully";
	}
	
	
	
	private UserDto userToUserDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
	return userDto;
	}
	
	
	private User userDtoToUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		return user;
	}
	
}
