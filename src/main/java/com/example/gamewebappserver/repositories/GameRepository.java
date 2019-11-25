package com.example.gamewebappserver.repositories;

import com.example.gamewebappserver.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository
    extends CrudRepository<Game, Integer> {
}
