package com.thiagoferraz.mychess.controllers;

import com.thiagoferraz.mychess.model.entities.Board;
import com.thiagoferraz.mychess.model.entities.Game;
import com.thiagoferraz.mychess.model.entities.Piece;
import com.thiagoferraz.mychess.model.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    private PieceController pieceController;

    @Autowired
    private BoardRepository boardRepository;

    @PostMapping("/new")
    public Board newBoard(Board board) {
        boardRepository.save(board);

        Iterable<Piece> pieces = pieceController.newPieces(board);
        List<Piece> pieceList = StreamSupport.stream(pieces.spliterator(), false)
                .collect(Collectors.toList());

        board.setPieces(pieceList);

        return board;
    }

}
