package com.thiagoferraz.mychess.repositories;

import com.thiagoferraz.mychess.model.entities.Piece;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceRepository extends CrudRepository<Piece, Integer> {
}
