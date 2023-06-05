package com.thiagoferraz.mychess.model.repositories;

import com.thiagoferraz.mychess.model.entities.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Integer> {
}