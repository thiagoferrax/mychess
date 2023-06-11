package com.thiagoferraz.mychess.repositories;

import com.thiagoferraz.mychess.model.entities.Move;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoveRepository extends CrudRepository<Move, Integer> {
}
