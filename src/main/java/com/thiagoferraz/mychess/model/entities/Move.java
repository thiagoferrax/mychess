package com.thiagoferraz.mychess.model.entities;

import com.thiagoferraz.mychess.model.tos.Position;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Move implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Piece piece;
    private Position toPosition;
    @Nullable
    private Move next;

    public Move() {
    }

    public Move(Integer id, Piece piece, Position toPosition, Move next) {
        this.id = id;
        this.piece = piece;
        this.toPosition = toPosition;
        this.next = next;
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
}
