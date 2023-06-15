package com.thiagoferraz.mychess.chessboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/chessboards")
public class ChessboardController {
    @Autowired
    private ChessboardService chessboardService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Chessboard createBoard(@RequestBody Chessboard chessboard) {
        return chessboardService.save(chessboard);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chessboard> getBoardById(@PathVariable Integer id) {
        Optional<Chessboard> chessboard = chessboardService.getBoardById(id);
        return chessboard.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}