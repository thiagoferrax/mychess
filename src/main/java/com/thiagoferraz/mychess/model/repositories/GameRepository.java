package com.thiagoferraz.mychess.model.repositories;

import com.thiagoferraz.mychess.model.entities.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {
}
