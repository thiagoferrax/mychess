package com.thiagoferraz.mychess.services;

import com.thiagoferraz.mychess.model.entities.Move;
import com.thiagoferraz.mychess.repositories.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoveService {
    @Autowired
    private MoveRepository moveRepository;

    public Optional<Move> findById(Integer id) {
        return moveRepository.findById(id);
    }

    public Move save(Move move) {
        return moveRepository.save(move);
    }

    public Iterable<Move> findAll() {
        return moveRepository.findAll();
    }
}