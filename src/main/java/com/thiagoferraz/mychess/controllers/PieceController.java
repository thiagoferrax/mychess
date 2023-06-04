package com.thiagoferraz.mychess.controllers;

import com.thiagoferraz.mychess.model.entities.Piece;
import com.thiagoferraz.mychess.model.enums.PieceColour;
import com.thiagoferraz.mychess.model.enums.PieceType;
import com.thiagoferraz.mychess.model.repositories.PieceRepository;
import com.thiagoferraz.mychess.model.tos.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/piece")
public class PieceController {

    @Autowired
    private PieceRepository pieceRepository;

    @PostMapping("/save")
    public Piece save(Piece piece) {
        return pieceRepository.save(piece);
    }

    @PostMapping("/saveAll")
    public Iterable<Piece> saveAll(Iterable<Piece> pieces) {
        return pieceRepository.saveAll(pieces);
    }

    @PostMapping("/newPieces")
    public Iterable<Piece> newPieces() {
        Iterable<Piece> pieces = List.of(
                new Piece(null, PieceType.Rook, PieceColour.White, new Position(0, 0)),
                new Piece(null, PieceType.Knight, PieceColour.White, new Position(1, 0)),
                new Piece(null, PieceType.Bishop, PieceColour.White, new Position(2, 0)),
                new Piece(null, PieceType.King, PieceColour.White, new Position(3, 0)),
                new Piece(null, PieceType.Queen, PieceColour.White, new Position(4, 0)),
                new Piece(null, PieceType.Bishop, PieceColour.White, new Position(5, 0)),
                new Piece(null, PieceType.Knight, PieceColour.White, new Position(6, 0)),
                new Piece(null, PieceType.Rook, PieceColour.White, new Position(7, 0)),

                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(0, 1)),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(1, 1)),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(2, 1)),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(3, 1)),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(4, 1)),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(5, 1)),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(6, 1)),
                new Piece(null, PieceType.Pawn, PieceColour.White, new Position(7, 1)),

                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(0, 6)),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(1, 6)),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(2, 6)),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(3, 6)),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(4, 6)),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(5, 6)),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(6, 6)),
                new Piece(null, PieceType.Pawn, PieceColour.Black, new Position(7, 6)),

                new Piece(null, PieceType.Rook, PieceColour.Black, new Position(0, 7)),
                new Piece(null, PieceType.Knight, PieceColour.Black, new Position(1, 7)),
                new Piece(null, PieceType.Bishop, PieceColour.Black, new Position(2, 7)),
                new Piece(null, PieceType.King, PieceColour.Black, new Position(3, 7)),
                new Piece(null, PieceType.Queen, PieceColour.Black, new Position(4, 7)),
                new Piece(null, PieceType.Bishop, PieceColour.Black, new Position(5, 7)),
                new Piece(null, PieceType.Knight, PieceColour.Black, new Position(6, 7)),
                new Piece(null, PieceType.Rook, PieceColour.Black, new Position(7, 7)));

        return pieceRepository.saveAll(pieces);
    }
}
