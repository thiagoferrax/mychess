package com.thiagoferraz.mychess.piece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PieceService {
    @Autowired
    private PieceRepository pieceRepository;

    public Iterable<Piece> saveAll(Iterable<Piece> pieces) {
        return pieceRepository.saveAll(pieces);
    }

    public Piece savePiece(Piece piece) {
        return pieceRepository.save(piece);
    }
}