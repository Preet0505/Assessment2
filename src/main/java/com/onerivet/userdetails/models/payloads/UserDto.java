package com.onerivet.userdetails.models.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	public int id;
	
	@NotEmpty(message = "Please Enter the first name!!")
    @Pattern(regexp = "[A-Z]{1}[A-Za-z]{2-8}", message = "Enter First letter in capital")
    @Pattern(regexp = "[A-Z]{1}[A-Za-z]{2-8}", message = "Enter valid first name")
	public String firstName;
	
	@NotEmpty(message = "Please Enter the Last name!!")
    @Pattern(regexp = "[A-Z]{1}[A-Za-z]{2-8}", message = "Enter First letter in capital")
    @Pattern(regexp = "[A-Z]{1}[A-Za-z]{2-8}", message = "Enter valid first name")
	public String lastName;
	
	@Email(message = "Enter email in valid format (Ex: abc@gmail.com)", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Email cannot be empty")
	public String userName;
	
	@NotEmpty(message = "Please enter the mobile number!!")
    @Pattern(regexp =  "[7-9]{1}[0-9]{9}", message = "Enter the valid mobile number!!")
	public int phoneNo;
	
	@NotEmpty(message = "Please Enter the password!!")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "Enter password in valid formate (Ex: Abc@123)")
	public String password;
}
