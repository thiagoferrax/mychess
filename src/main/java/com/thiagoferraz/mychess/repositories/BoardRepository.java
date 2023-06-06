package com.thiagoferraz.mychess.repositories;

import com.thiagoferraz.mychess.model.entities.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<Board, Integer> {
}