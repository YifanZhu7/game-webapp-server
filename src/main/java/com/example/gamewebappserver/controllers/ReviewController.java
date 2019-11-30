package com.example.gamewebappserver.controllers;


import com.example.gamewebappserver.models.Game;
import com.example.gamewebappserver.models.Review;
import com.example.gamewebappserver.models.User;
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
public class ReviewController {

  @Autowired
  ReviewRepository reviewRepository;
  @Autowired
  UserRepository userRepository;

//  @GetMapping("/users/{userId}/reviews")
//  public List<Review> findAllReviews(
//      @PathVariable("userId") int userId) {
//    return reviewRepository.findReviewsForUser(userId);
//  }

  @PostMapping("/users/{userId}/reviews")
  public List<User> createReviewForUser(
      @PathVariable("userId") int userId,
      @RequestBody Review review) {
    Optional<User> data = userRepository.findById(userId);
    if(data.isPresent()){
      User user = data.get();
      review.setUser(user);
      reviewRepository.save(review);
      return (List<User>) userRepository.findAll();
    }
    return null;
  }
}
