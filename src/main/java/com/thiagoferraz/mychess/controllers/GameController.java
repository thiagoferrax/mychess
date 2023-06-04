package com.thiagoferraz.mychess.controllers;

import com.thiagoferraz.mychess.model.entities.Board;
import com.thiagoferraz.mychess.model.entities.Game;
import com.thiagoferraz.mychess.model.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    BoardController boardController;
    @Autowired
    GameRepository gameRepository;

    @PostMapping("/newGame")
    public Game newGame() {
        Board board = boardController.save();
        return gameRepository.save(new Game(null, board, new Date(), null));
    }

}
