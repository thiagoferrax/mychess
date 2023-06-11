package com.thiagoferraz.mychess.controllers;

import com.thiagoferraz.mychess.model.entities.Board;
import com.thiagoferraz.mychess.model.entities.Game;
import com.thiagoferraz.mychess.model.enums.GameStatus;
import com.thiagoferraz.mychess.services.BoardService;
import com.thiagoferraz.mychess.services.GameService;
import com.thiagoferraz.mychess.services.PieceService;
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
    private BoardService boardService;

    @MockBean
    private PieceService pieceService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenUrlCodeExistsReturnsExistingUrl() throws Exception {
        // Given
        Date date = new Date();

        Board board = new Board();
        board.setId(1);

        Game game = new Game();
        game.setId(1);
        game.setStatus(GameStatus.ACTIVE);
        game.setStart(date);
        game.setBoard(board);

        given(gameService.createGame()).willReturn(game);

        // When and Then
        this.mockMvc.perform(post("/games/new")).andExpect(status().isOk());
    }
}
