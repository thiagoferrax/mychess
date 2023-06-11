package com.thiagoferraz.mychess.model.entities;

import com.thiagoferraz.mychess.model.tos.Position;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
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
    private Board board;
    private Date creation;

    public Move() {
    }

    public Move(Integer id, Piece piece, Position toPosition, @Nullable Move next, Board board, Date creation) {
        this.id = id;
        this.piece = piece;
        this.toPosition = toPosition;
        this.next = next;
        this.board = board;
        this.creation = creation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Position getToPosition() {
        return toPosition;
    }

    public void setToPosition(Position toPosition) {
        this.toPosition = toPosition;
    }

    public Move getNext() {
        return next;
    }

    public void setNext(Move next) {
        this.next = next;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return Objects.equals(id, move.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Move{" +
                "id=" + id +
                ", piece=" + piece +
                ", toPosition=" + toPosition +
                ", next=" + next +
                '}';
    }


    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

}
