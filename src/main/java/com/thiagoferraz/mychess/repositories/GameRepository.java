package com.thiagoferraz.mychess.repositories;

import com.thiagoferraz.mychess.model.entities.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
}
