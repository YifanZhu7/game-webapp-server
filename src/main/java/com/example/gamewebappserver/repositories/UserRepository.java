package com.example.gamewebappserver.repositories;

import com.example.gamewebappserver.models.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository
    extends CrudRepository<User, Integer> {
//  public User findUser();
}
