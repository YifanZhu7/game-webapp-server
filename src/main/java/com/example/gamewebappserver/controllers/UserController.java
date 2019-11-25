package com.example.gamewebappserver.controllers;

import com.example.gamewebappserver.models.User;
import com.example.gamewebappserver.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

  @Autowired
  UserRepository repository;

  @PostMapping("/user")
  public User createUser(
      @RequestBody User user){
    return repository.save(user);
  }


//  @GetMapping("/api/user")
//  public List<User> findUser() {
//    return (List<User>) repository.findAll();
//  }

}
