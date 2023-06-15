package com.thiagoferraz.mychess.player;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    Optional<Player> findByEmail(String email);
}