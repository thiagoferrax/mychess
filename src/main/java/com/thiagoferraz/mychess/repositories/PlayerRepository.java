package com.thiagoferraz.mychess.repositories;

import com.thiagoferraz.mychess.model.entities.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    Optional<Player> findByEmail(String email);
}