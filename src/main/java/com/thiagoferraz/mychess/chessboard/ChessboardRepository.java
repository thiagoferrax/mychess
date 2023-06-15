package com.thiagoferraz.mychess.chessboard;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChessboardRepository extends CrudRepository<Chessboard, Integer> {
}