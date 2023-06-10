package com.thiagoferraz.mychess.services;

import com.thiagoferraz.mychess.model.entities.Board;
import com.thiagoferraz.mychess.model.entities.Game;
import com.thiagoferraz.mychess.model.enums.GameStatus;
import com.thiagoferraz.mychess.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private BoardService boardService;

    public Game createNewGame() {
        Game game = newGame();
        Board board = boardService.createNewBoard(game);
        game.setBoard(board);
        return gameRepository.save(game);
    }


    private Game newGame() {
        Game game = new Game();
        game.setStatus(GameStatus.ACTIVE);
        game.setStart(new Date());
        return game;
    }

    public Optional<Game> findById(Integer id) {
        return gameRepository.findById(id);
    }
}