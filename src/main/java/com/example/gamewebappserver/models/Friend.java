package com.example.gamewebappserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.tools.javah.Gen;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "friends")
public class Friend {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String username;

  @ManyToOne
  @JsonIgnore
  private User user;

  @OneToMany(mappedBy = "friend")
  private List<Review> reviews = new ArrayList<>();

  @OneToMany(mappedBy = "friend")
  private List<Game> games = new ArrayList<>();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  public List<Game> getGames() {
    return games;
  }

  public void setGames(List<Game> games) {
    this.games = games;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  //  public List<Friend> getFriends() {
//    return friends;
//  }
//
//  public void setFriends(List<Friend> friends) {
//    this.friends = friends;
//  }
}
