package com.onerivet.userdetails.services.servicesimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.onerivet.userdetails.models.entity.User;
import com.onerivet.userdetails.models.entity.UserInfoUserDetails;
import com.onerivet.userdetails.repository.UserRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	
	 @Autowired
	    private UserRepository userRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
	        Optional<User> userInfo = userRepository.findByUserName(username);
	        return userInfo.map(UserInfoUserDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

	    }

}
