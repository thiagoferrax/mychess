package com.thiagoferraz.mychess.chessboard;

import com.thiagoferraz.mychess.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChessboardService {
    @Autowired
    private ChessboardRepository chessboardRepository;

    public Chessboard createNewBoard(Game game) {
        Chessboard chessboard = new Chessboard();
        chessboard.setGame(game);
        return save(chessboard);
    }

    public Chessboard save(Chessboard chessboard) {
        return chessboardRepository.save(chessboard);
    }

    public Optional<Chessboard> getBoardById(Integer id) {
        return chessboardRepository.findById(id);
    }
}