package com.thiagoferraz.mychess.controllers;

import com.thiagoferraz.mychess.model.entities.Piece;
import com.thiagoferraz.mychess.services.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pieces")
public class PieceController {

    @Autowired
    private PieceService pieceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Piece createPiece(@RequestBody Piece piece) {
        return pieceService.savePiece(piece);
    }

    @PostMapping("/bulk")
    @ResponseStatus(HttpStatus.CREATED)
    public Iterable<Piece> createPieces(@RequestBody Iterable<Piece> pieces) {
        return pieceService.saveAll(pieces);
    }
}
