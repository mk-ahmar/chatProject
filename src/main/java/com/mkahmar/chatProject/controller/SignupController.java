package com.mkahmar.chatProject.controller;

import com.mkahmar.chatProject.dto.UserRegistrationDto;
import com.mkahmar.chatProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignupController {

  private final UserService userService;

  @Autowired
  public SignupController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/signup")
  public String showForm(Model model) {
    model.addAttribute("userForm", new UserRegistrationDto());
    return "signup";
  }

  @PostMapping("/signup")
  public String processForm(
      @ModelAttribute("userForm") @Valid UserRegistrationDto userForm,
      BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "signup";
    }

    userService.register(userForm);
    // after registration, redirect to login and show a flag
    return "redirect:/login?registered";
  }
}
