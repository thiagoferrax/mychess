package com.thiagoferraz.mychess.game;

import com.thiagoferraz.mychess.chessboard.Chessboard;
import com.thiagoferraz.mychess.chessboard.ChessboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GameService {
    Logger logger = LoggerFactory.getLogger(GameService.class);

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ChessboardService chessboardService;

    public Game createGame() {
        logger.info("Creating a new game and chessboard with pieces in their original position.");
        Game game = newGame();
        Chessboard chessboard = chessboardService.createNewBoard(game);
        game.setChessboard(chessboard);
        return gameRepository.save(game);
    }


    private Game newGame() {
        Game game = new Game();
        game.setStatus(GameStatus.ACTIVE);
        game.setStart(new Date());
        return game;
    }

    public Optional<Game> findById(Integer id) {
        return gameRepository.findById(id);
    }
}