package com.thiagoferraz.mychess.services;

import com.thiagoferraz.mychess.exceptions.MoveNotAllowedException;
import com.thiagoferraz.mychess.model.entities.Move;
import com.thiagoferraz.mychess.model.entities.Piece;
import com.thiagoferraz.mychess.model.tos.Position;
import com.thiagoferraz.mychess.repositories.MoveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MoveService {
    Logger logger = LoggerFactory.getLogger(GameService.class);

    @Autowired
    private PieceService pieceService;

    @Autowired
    private MoveRepository moveRepository;

    public Optional<Move> getMoveById(Integer id) {
        return moveRepository.findById(id);
    }

    public Move saveMove(Move move) {
        Position toPosition = move.getToPosition();

        if(toPosition.getX() < 0 || toPosition.getY() < 0) {
            logger.warn("Move is not allowed.");
            throw new MoveNotAllowedException("Move is not allowed.");
        }

        Piece piece = move.getPiece();
        piece.setPosition(toPosition);
        Piece saved = pieceService.savePiece(piece);

        move.setPiece(saved);
        move.setCreation(new Date());

        return moveRepository.save(move);
    }

    public Iterable<Move> findAllMoves() {
        return moveRepository.findAll();
    }
}