package com.thiagoferraz.mychess.game;

import com.thiagoferraz.mychess.chessboard.Chessboard;
import com.thiagoferraz.mychess.piece.Piece;
import com.thiagoferraz.mychess.piece.PieceColour;
import com.thiagoferraz.mychess.piece.PieceType;
import com.thiagoferraz.mychess.piece.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame() {
        Game game = gameService.createGame();
        Chessboard chessboard = game.getChessboard();
        chessboard.setPieces(getPiecesInitialPosition(chessboard));
        return game;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Integer id) {
        Optional<Game> game = gameService.findById(id);
        return game.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    private List<Piece> getPiecesInitialPosition(Chessboard chessboard) {
        return List.of(
                new Piece(null, PieceType.Rook, PieceColour.White, new Position(0, 0), chessboard),
                new Piece(null, PieceType.Knight, PieceColour.White, new Position(1, 0), chessboard),
                new Piece(null, PieceType.Bishop, PieceColour.White, new Position(2, 0), chessboard),
                new Piece(null, PieceType.King, PieceColour.White, new Position(3, 0), chessboard),
                new Piece(null, PieceType.Queen, PieceColour.White, new Position(4, 0), chessboard),
                new Piece(null, PieceType.Bishop, PieceColour.White, new Position(5, 0), chessboard),
                new Piece(null, PieceType.Knight, PieceColour.White, new Position(6, 0), chessboard),
                new Piece(null, PieceType.Rook, PieceColour.White, new Position(7, 0), chessboard),

                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(0, 1), chessboard),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(1, 1), chessboard),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(2, 1), chessboard),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(3, 1), chessboard),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(4, 1), chessboard),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(5, 1), chessboard),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(6, 1), chessboard),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(7, 1), chessboard),

                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(0, 6), chessboard),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(1, 6), chessboard),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(2, 6), chessboard),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(3, 6), chessboard),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(4, 6), chessboard),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(5, 6), chessboard),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(6, 6), chessboard),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(7, 6), chessboard),

                new Piece(null, PieceType.Rook, PieceColour.Black, new Position(0, 7), chessboard),
                new Piece(null, PieceType.Knight, PieceColour.Black, new Position(1, 7), chessboard),
                new Piece(null, PieceType.Bishop, PieceColour.Black, new Position(2, 7), chessboard),
                new Piece(null, PieceType.King, PieceColour.Black, new Position(3, 7), chessboard),
                new Piece(null, PieceType.Queen, PieceColour.Black, new Position(4, 7), chessboard),
                new Piece(null, PieceType.Bishop, PieceColour.Black, new Position(5, 7), chessboard),
                new Piece(null, PieceType.Knight, PieceColour.Black, new Position(6, 7), chessboard),
                new Piece(null, PieceType.Rook, PieceColour.Black, new Position(7, 7), chessboard));
    }

}
