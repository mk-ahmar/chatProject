package com.mkahmar.chatProject.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class UserRegistrationDto {
  
  @NotBlank(message = "Name is required")
  private String name;

  @Email(message = "Enter a valid email")
  @NotBlank(message = "Email is required")
  private String email;

  @NotNull(message = "Date of birth is required")
  private LocalDate dob;

  @NotBlank(message = "Username is required")
  @Size(min = 4, max = 20, message = "Username must be 4–20 characters")
  private String username;

  @NotBlank(message = "Password is required")
  @Size(min = 6, message = "Password must be ≥6 characters")
  private String password;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public LocalDate getDob() {
	return dob;
}

public void setDob(LocalDate dob) {
	this.dob = dob;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

  
}
