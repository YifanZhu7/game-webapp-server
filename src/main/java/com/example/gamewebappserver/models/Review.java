package com.example.gamewebappserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int gameId;
  private String review;

  @ManyToOne
  @JsonIgnore
  private User user;

  public Review(){}


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }



  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public int getGameId() {
    return gameId;
  }

  public void setGameId(int gameId) {
    this.gameId = gameId;
  }
}
