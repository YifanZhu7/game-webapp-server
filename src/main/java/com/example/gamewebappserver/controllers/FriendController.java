package com.example.gamewebappserver.controllers;

import com.example.gamewebappserver.models.Friend;
import com.example.gamewebappserver.models.Game;
import com.example.gamewebappserver.models.Review;
import com.example.gamewebappserver.models.User;
import com.example.gamewebappserver.repositories.FriendRepository;
import com.example.gamewebappserver.repositories.GameRepository;
import com.example.gamewebappserver.repositories.ReviewRepository;
import com.example.gamewebappserver.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class FriendController {

  @Autowired
  FriendRepository friendRepository;
  @Autowired
  UserRepository userRepository;


  @GetMapping("/users/{userId}/friends")
  public List<Friend> findAllFriends(
      @PathVariable("userId") int userId) {
    return friendRepository.findFriendForUser(userId);
  }


  @PostMapping("/users/{userId}/friends")
  public List<Friend> addFriendForUser(
      @PathVariable("userId") int userId,
      @RequestBody Friend friend) {
    Optional<User> data = userRepository.findById(userId);
    if(data.isPresent()){
      User user = data.get();
      if(!user.getFriends().contains(friend)) {
        friend.setUser(user);
        friendRepository.save(friend);
        return (List<Friend>) friendRepository.findAll();
      }
    }
    return null;
  }

  @DeleteMapping("/users/{userId}/friends/{friendId}")
  public List<Friend> deleteFriendForUser(
      @PathVariable("friendId") int friendId,
      @PathVariable("userId") int userId) {
    friendRepository.deleteById(friendId);
    return friendRepository.findFriendForUser(userId);
  }

//  @DeleteMapping("/friends/{friendId}")
//  public List<Friend> deleteFriend(
//      @PathVariable("friendId") int friendId) {
//    friendRepository.deleteById(friendId);
//    return (List<Friend>) friendRepository.findAll();
//  }
//
//  @PostMapping("/friends/{friendId}/games")
//  public Game createGameForFriend(
//      @PathVariable("friendId") int friendId,
//      @RequestBody Game game) {
//    Optional<Friend> data = friendRepository.findById(friendId);
//    if (data.isPresent()) {
//      Friend friend = data.get();
//      game.setFriend(friend);
//      return gameRepository.save(game);
//    }
//    return null;
//  }
}
