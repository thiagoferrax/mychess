package com.thiagoferraz.mychess.controllers;

import com.thiagoferraz.mychess.model.entities.Piece;
import com.thiagoferraz.mychess.services.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/piece")
public class PieceController {

    @Autowired
    private PieceService pieceService;

    @PostMapping("/save")
    public Piece save(Piece piece) {
        return pieceService.save(piece);
    }

    @PostMapping("/saveAll")
    public Iterable<Piece> saveAll(Iterable<Piece> pieces) {
        return pieceService.saveAll(pieces);
    }
}
