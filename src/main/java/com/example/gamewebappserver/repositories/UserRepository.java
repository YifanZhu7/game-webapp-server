package com.example.gamewebappserver.repositories;

import com.example.gamewebappserver.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository
    extends CrudRepository<User, Integer> {

  @Query("select user from User user where user.username=:usn")
  public User findUserByUsn(
      @Param("usn") String usn);
}
