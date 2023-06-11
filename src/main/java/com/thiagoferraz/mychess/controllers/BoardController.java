package com.thiagoferraz.mychess.controllers;

import com.thiagoferraz.mychess.model.entities.Board;
import com.thiagoferraz.mychess.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Board createBoard(@RequestBody Board board) {
        return boardService.save(board);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable Integer id) {
        Optional<Board> board = boardService.findById(id);
        return board.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}