package com.example.gamewebappserver.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String username;
  private int password;
  private String birthday;
  private String gender;
  private String email;

  @OneToMany(mappedBy = "user")
  private List<Review> reviews = new ArrayList<>();

//  @OneToMany(mappedBy = "user")
//  private List<User> friends = new ArrayList<>();

  @OneToMany(mappedBy = "user")
  private List<Game> games = new ArrayList<>();

  public User(){}


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

//  public List<User> getFriends() {
//    return friends;
//  }
//
//  public void setFriends(List<User> friends) {
//    this.friends = friends;
//  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getPassword() {
    return password;
  }

  public void setPassword(int password) {
    this.password = password;
  }

  public String getBirth_day() {
    return birthday;
  }

  public void setBirth_day(String birth_day) {
    this.birthday = birth_day;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Game> getGames() {
    return games;
  }

  public void setGames(List<Game> games) {
    this.games = games;
  }
}
