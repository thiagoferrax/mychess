package com.thiagoferraz.mychess.controllers;

import com.thiagoferraz.mychess.model.entities.Move;
import com.thiagoferraz.mychess.model.entities.Piece;
import com.thiagoferraz.mychess.services.MoveService;
import com.thiagoferraz.mychess.services.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/moves")
public class MoveController {
    @Autowired
    private MoveService moveService;

    @Autowired
    private PieceService pieceService;

    @GetMapping("/{id}")
    public ResponseEntity<Move> findById(@PathVariable Integer id) {
        Optional<Move> move = moveService.findById(id);
        if (move.isPresent()) {
            return ResponseEntity.ok(move.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/new")
    public Move save(@RequestBody Move move) {
        Piece piece = move.getPiece();
        piece.setPosition(move.getToPosition());

        Piece savedPiece = pieceService.save(piece);

        move.setPiece(savedPiece);
        move.setCreation(new Date());

        return moveService.save(move);
    }

    @GetMapping
    public Iterable<Move> findAll() {
        return moveService.findAll();
    }
}
