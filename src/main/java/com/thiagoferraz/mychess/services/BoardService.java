package com.thiagoferraz.mychess.services;

import com.thiagoferraz.mychess.model.entities.Board;
import com.thiagoferraz.mychess.model.entities.Game;
import com.thiagoferraz.mychess.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public Board createNewBoard(Game game) {
        Board board = new Board();
        board.setGame(game);
        return save(board);
    }

    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public Optional<Board> findById(Integer id) {
        return boardRepository.findById(id);
    }
}