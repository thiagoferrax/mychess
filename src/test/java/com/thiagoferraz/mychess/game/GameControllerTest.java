package com.thiagoferraz.mychess.game;

import com.thiagoferraz.mychess.chessboard.Chessboard;
import com.thiagoferraz.mychess.chessboard.ChessboardService;
import com.thiagoferraz.mychess.piece.PieceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class GameControllerTest {
    @MockBean
    GameService gameService;

    @MockBean
    private ChessboardService chessboardService;

    @MockBean
    private PieceService pieceService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenUrlCodeExistsReturnsExistingUrl() throws Exception {
        // Given
        Date date = new Date();

        Chessboard chessboard = new Chessboard();
        chessboard.setId(1);

        Game game = new Game();
        game.setId(1);
        game.setStatus(GameStatus.ACTIVE);
        game.setStart(date);
        game.setChessboard(chessboard);

        given(gameService.createGame()).willReturn(game);

        // When and Then
        this.mockMvc.perform(post("/games/new")).andExpect(status().isOk());
    }
}
