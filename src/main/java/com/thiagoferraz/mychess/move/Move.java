package com.thiagoferraz.mychess.move;

import com.thiagoferraz.mychess.chessboard.Chessboard;
import com.thiagoferraz.mychess.piece.Piece;
import com.thiagoferraz.mychess.piece.Position;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Move implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pieceId")
    private Piece piece;

    private Position toPosition;

    @OneToOne
    @JoinColumn(name = "moveId")
    @Nullable
    private Move next;

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Chessboard chessboard;

    private Date creation;
}
