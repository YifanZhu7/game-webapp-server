package com.example.gamewebappserver.controllers;

import com.example.gamewebappserver.models.Game;
import com.example.gamewebappserver.models.User;
import com.example.gamewebappserver.repositories.GameRepository;
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
public class GameController {

  @Autowired
  GameRepository gameRepository;
  @Autowired
  UserRepository userRepository;

  @GetMapping("/users/{userId}/games")
  public List<Game> findAllGames(
      @PathVariable("userId") int userId) {
    return gameRepository.findGamesForUser(userId);
  }

  @DeleteMapping("/users/{userId}/games/{gameId}")
  public List<Game> deleteGameForUser(
      @PathVariable("gameId") int gameId,
      @PathVariable("userId") int userId) {
    gameRepository.deleteById(gameId);
    return gameRepository.findGamesForUser(userId);
  }

  @PostMapping("/users/{userId}/games")
  public Game createGameForUser(
      @PathVariable("userId") int userId,
      @RequestBody Game game) {
    Optional<User> data = userRepository.findById(userId);
    if(data.isPresent()){
      User user = data.get();
      game.setUser(user);
      return gameRepository.save(game);
    }
    return null;
  }




}
