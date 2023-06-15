package com.thiagoferraz.mychess.piece;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thiagoferraz.mychess.chessboard.Chessboard;
import com.thiagoferraz.mychess.move.Move;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Piece implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer type;

    private Integer colour;

    private Position position;

    @OneToMany(mappedBy = "piece")
    @JsonIgnore
    private List<Move> moves;

    @ManyToOne
    @JoinColumn(name = "boardId")
    @JsonIgnore
    private Chessboard chessboard;

    public Piece(Integer id, PieceType pieceType, PieceColour pieceColour, Position position, Chessboard chessboard) {
        this.id = id;
        this.type = pieceType.getId();
        this.colour = pieceColour.getId();
        this.position = position;
        this.chessboard = chessboard;
    }
}
