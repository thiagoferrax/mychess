package com.thiagoferraz.mychess.model.repositories;

import com.thiagoferraz.mychess.model.entities.Piece;
import org.springframework.data.repository.CrudRepository;

public interface PieceRepository extends CrudRepository<Piece, Integer> {
}
