package com.thiagoferraz.mychess.controllers;

import com.thiagoferraz.mychess.model.entities.Move;
import com.thiagoferraz.mychess.model.entities.Piece;
import com.thiagoferraz.mychess.services.MoveService;
import com.thiagoferraz.mychess.services.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/moves")
public class MoveController {
    @Autowired
    private MoveService moveService;

    @Autowired
    private PieceService pieceService;

    @GetMapping("/{id}")
    public ResponseEntity<Move> getMoveById(@PathVariable Integer id) {
        Optional<Move> move = moveService.getMoveById(id);
        return move.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Move saveMove(@RequestBody Move move) {
        Piece piece = move.getPiece();
        piece.setPosition(move.getToPosition());
        Piece saved = pieceService.savePiece(piece);

        move.setPiece(saved);
        move.setCreation(new Date());
        return moveService.saveMove(move);
    }

    @GetMapping
    public Iterable<Move> findAllMoves() {
        return moveService.findAllMoves();
    }
}
