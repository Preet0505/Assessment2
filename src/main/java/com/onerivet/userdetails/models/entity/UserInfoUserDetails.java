package com.onerivet.userdetails.models.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserInfoUserDetails implements UserDetails {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	    private String password;

	    public UserInfoUserDetails(User user) {
	    	userName=user.getUserName();
	        password=user.getPassword();
	    }
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return null;
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public String getUsername() {
	        return userName;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

}
