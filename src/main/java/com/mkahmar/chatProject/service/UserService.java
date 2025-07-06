package com.mkahmar.chatProject.service;

import com.mkahmar.chatProject.dto.UserRegistrationDto;
import com.mkahmar.chatProject.model.User;

public interface UserService {
  User register(UserRegistrationDto dto);
}
