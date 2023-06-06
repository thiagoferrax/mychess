package com.thiagoferraz.mychess.controllers;

import com.thiagoferraz.mychess.model.entities.Board;
import com.thiagoferraz.mychess.model.entities.Game;
import com.thiagoferraz.mychess.model.entities.Piece;
import com.thiagoferraz.mychess.model.enums.GameStatus;
import com.thiagoferraz.mychess.model.enums.PieceColour;
import com.thiagoferraz.mychess.model.enums.PieceType;
import com.thiagoferraz.mychess.model.tos.Position;
import com.thiagoferraz.mychess.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping("/new")
    public Game createNewGame() {
        Game game = gameService.createNewGame();
        game.getBoard().setPieces(newPieces(game.getBoard()));
        return game;
    }

    private List<Piece> newPieces(Board board) {
        return List.of(
                new Piece(null, PieceType.Rook, PieceColour.White, new Position(0, 0), board),
                new Piece(null, PieceType.Knight, PieceColour.White, new Position(1, 0), board),
                new Piece(null, PieceType.Bishop, PieceColour.White, new Position(2, 0), board),
                new Piece(null, PieceType.King, PieceColour.White, new Position(3, 0), board),
                new Piece(null, PieceType.Queen, PieceColour.White, new Position(4, 0), board),
                new Piece(null, PieceType.Bishop, PieceColour.White, new Position(5, 0), board),
                new Piece(null, PieceType.Knight, PieceColour.White, new Position(6, 0), board),
                new Piece(null, PieceType.Rook, PieceColour.White, new Position(7, 0), board),

                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(0, 1), board),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(1, 1), board),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(2, 1), board),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(3, 1), board),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(4, 1), board),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(5, 1), board),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(6, 1), board),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(7, 1), board),

                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(0, 6), board),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(1, 6), board),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(2, 6), board),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(3, 6), board),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(4, 6), board),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(5, 6), board),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(6, 6), board),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(7, 6), board),

                new Piece(null, PieceType.Rook, PieceColour.Black, new Position(0, 7), board),
                new Piece(null, PieceType.Knight, PieceColour.Black, new Position(1, 7), board),
                new Piece(null, PieceType.Bishop, PieceColour.Black, new Position(2, 7), board),
                new Piece(null, PieceType.King, PieceColour.Black, new Position(3, 7), board),
                new Piece(null, PieceType.Queen, PieceColour.Black, new Position(4, 7), board),
                new Piece(null, PieceType.Bishop, PieceColour.Black, new Position(5, 7), board),
                new Piece(null, PieceType.Knight, PieceColour.Black, new Position(6, 7), board),
                new Piece(null, PieceType.Rook, PieceColour.Black, new Position(7, 7), board));
    }

}
