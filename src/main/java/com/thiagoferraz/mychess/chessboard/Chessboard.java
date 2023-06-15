package com.thiagoferraz.mychess.chessboard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thiagoferraz.mychess.game.Game;
import com.thiagoferraz.mychess.move.Move;
import com.thiagoferraz.mychess.piece.Piece;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Chessboard implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @OneToMany(mappedBy = "chessboard", fetch = FetchType.EAGER)
    private List<Piece> pieces = new ArrayList<>();

    @OneToMany(mappedBy = "chessboard")
    @JsonIgnore
    private List<Move> moves = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "gameId")
    @MapsId
    @JsonIgnore
    private Game game;
}
