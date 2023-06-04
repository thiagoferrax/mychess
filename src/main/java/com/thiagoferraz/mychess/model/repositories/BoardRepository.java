package com.thiagoferraz.mychess.model.repositories;

import com.thiagoferraz.mychess.model.entities.Piece;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Piece, Integer> {
}