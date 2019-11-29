package com.example.gamewebappserver.repositories;

import com.example.gamewebappserver.models.Game;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GameRepository
    extends CrudRepository<Game, Integer> {
  @Query("select game from Game game where game.user.id=:userId")
  public List<Game> findGamesForUser(
      @Param("userId") Integer id
  );
}
