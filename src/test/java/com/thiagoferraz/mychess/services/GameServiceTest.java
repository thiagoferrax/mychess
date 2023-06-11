package com.thiagoferraz.mychess.services;

import com.thiagoferraz.mychess.model.entities.Game;
import com.thiagoferraz.mychess.repositories.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @Mock
    private BoardService boardService;

    @InjectMocks
    private GameService gameService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById_ExistingId_ShouldReturnGameOptional() {
        // Mock dependencies
        int gameId = 1;
        Game game = new Game();
        game.setId(gameId);
        // Mock any necessary behavior for gameRepository.findById()

        when(gameRepository.findById(gameId)).thenReturn(Optional.of(game));

        // Call the method under test
        Optional<Game> result = gameService.findById(gameId);

        // Verify the result
        assertEquals(Optional.of(game), result);
    }

    @Test
    void findById_NonExistingId_ShouldReturnEmptyOptional() {
        // Mock dependencies
        int gameId = 1;
        // Mock any necessary behavior for gameRepository.findById()

        when(gameRepository.findById(gameId)).thenReturn(Optional.empty());

        // Call the method under test
        Optional<Game> result = gameService.findById(gameId);

        // Verify the result
        assertEquals(Optional.empty(), result);
    }
}