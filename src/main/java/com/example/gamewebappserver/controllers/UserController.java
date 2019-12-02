package com.example.gamewebappserver.controllers;

import com.example.gamewebappserver.models.User;
import com.example.gamewebappserver.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping("/login/{usn}")
  public User findUserByUsn(
      @PathVariable("usn") String usn){
    return repository.findUserByUsn(usn);
  }

  @PutMapping("/users/{uid}")
  public User updateUser(
      @PathVariable("uid") int uid,
      @RequestBody User updateUser) {
    User u = repository.findById(uid).get();
    u.set(updateUser);
    return repository.save(u);
  }

}
