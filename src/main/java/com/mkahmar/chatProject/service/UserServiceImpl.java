package com.mkahmar.chatProject.service;

import com.mkahmar.chatProject.dto.UserRegistrationDto;
import com.mkahmar.chatProject.model.User;
import com.mkahmar.chatProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepo;
  private final BCryptPasswordEncoder passwordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepo,
                         BCryptPasswordEncoder passwordEncoder) {
    this.userRepo = userRepo;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User register(UserRegistrationDto dto) {
    // Map DTO to entity
    User user = new User();
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    user.setDob(dto.getDob());
    user.setUsername(dto.getUsername());
    // Encode password!
    user.setPassword(passwordEncoder.encode(dto.getPassword()));
    return userRepo.save(user);
  }
}
