package com.example.gamewebappserver.controllers;

import com.example.gamewebappserver.models.User;
import com.example.gamewebappserver.repositories.UserRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

  @Autowired
  UserRepository repository;

  @PostMapping("/users")
  public User createUser(
      @RequestBody User user){
    return repository.save(user);
  }

  @GetMapping("/users")
  public List<User> findAllUsers() {
    return(List<User>) repository.findAll();
  }

  @GetMapping("/users/{uid}")
  public User findUserById(
      @PathVariable("uid") int uid) {
    Optional<User> c = repository.findById(uid);
    if (c.isPresent()) {
      return c.get();
    }
    return null;
  }

  @GetMapping("/login/{usn}/{psd}")
  public Boolean userLogin(
      @PathVariable("usn") String usn,
  @PathVariable("psd") String psd){
    if (repository.verifyPassword(usn).getPassword().equals(psd)){
      return true;
    }
    else {
      return false;
    }
  }



//  @GetMapping("/api/user")
//  public List<User> findUser() {
//    return (List<User>) repository.findAll();
//  }

}
