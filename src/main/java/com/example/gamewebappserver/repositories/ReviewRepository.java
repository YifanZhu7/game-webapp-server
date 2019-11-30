package com.example.gamewebappserver.repositories;

import com.example.gamewebappserver.models.Game;
import com.example.gamewebappserver.models.Review;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository
    extends CrudRepository<Review, Integer> {
  @Query("select review from Review review where review.user.id=:userId")
  public List<Review> findReviewsForUser(
      @Param("userId") Integer id
  );}
