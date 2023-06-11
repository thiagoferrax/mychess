package com.thiagoferraz.mychess.services;

import com.thiagoferraz.mychess.model.entities.Move;
import com.thiagoferraz.mychess.repositories.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MoveService {
    @Autowired
    private MoveRepository moveRepository;

    public Optional<Move> getMoveById(Integer id) {
        return moveRepository.findById(id);
    }

    public Move saveMove(Move move) {
        return moveRepository.save(move);
    }

    public Iterable<Move> findAllMoves() {
        return moveRepository.findAll();
    }
}