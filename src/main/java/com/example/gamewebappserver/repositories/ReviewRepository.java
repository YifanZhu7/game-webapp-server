package com.example.gamewebappserver.repositories;

import com.example.gamewebappserver.models.Review;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository
    extends CrudRepository<Review, Integer> {
//  public List<Review> findAllReview();
}
