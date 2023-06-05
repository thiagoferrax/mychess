package com.thiagoferraz.mychess.controllers;

import com.thiagoferraz.mychess.model.entities.Board;
import com.thiagoferraz.mychess.model.entities.Game;
import com.thiagoferraz.mychess.model.entities.Piece;
import com.thiagoferraz.mychess.model.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    BoardController boardController;

    @Autowired
    PieceController pieceController;

    @Autowired
    GameRepository gameRepository;

    @PostMapping("/new")
    public Game newGame() {

        Game game = new Game(null, null, new Date(), null);
        Board board = boardController.newBoard(new Board(null, game));

        game.setBoard(board);

        Game savedGame = gameRepository.save(game);

        List<Piece> pieces = pieceController.newPieces(board);
        board.setPieces(pieces);

        return savedGame;
    }

}
