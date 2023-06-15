package com.thiagoferraz.mychess.move;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/moves")
public class MoveController {
    @Autowired
    private MoveService moveService;

    @GetMapping("/{id}")
    public ResponseEntity<Move> getMoveById(@PathVariable Integer id) {
        Optional<Move> move = moveService.getMoveById(id);
        return move.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Move saveMove(@RequestBody Move move) {
        return moveService.saveMove(move);
    }

    @GetMapping
    public Iterable<Move> findAllMoves() {
        return moveService.findAllMoves();
    }
}
