package com.thiagoferraz.mychess.controllers;

import com.thiagoferraz.mychess.model.entities.Board;
import com.thiagoferraz.mychess.model.entities.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private PieceController pieceController;

    @PostMapping("/save")
    public Board save() {
        Iterable<Piece> pieces = pieceController.newPieces();
        List<Piece> pieceList = StreamSupport.stream(pieces.spliterator(), false)
                .collect(Collectors.toList());

        Board board = new Board(null);
        board.setPieces(pieceList);

        return board;
    }

}
