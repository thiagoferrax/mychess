package com.thiagoferraz.mychess.model.entities;

import com.thiagoferraz.mychess.model.enums.PieceColour;
import com.thiagoferraz.mychess.model.enums.PieceType;
import com.thiagoferraz.mychess.model.tos.Position;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Piece implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private PieceType type;
    private PieceColour colour;
    private Position position;
    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;

    public Piece() {

    }

    public Piece(Integer id, PieceType type, PieceColour colour, Position position, Board board) {
        this.id = id;
        this.type = type;
        this.colour = colour;
        this.position = position;
        this.board = board;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

    public PieceColour getColour() {
        return colour;
    }

    public void setColour(PieceColour colour) {
        this.colour = colour;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Objects.equals(id, piece.id) && type == piece.type && colour == piece.colour && Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, colour, position);
    }

    @Override
    public String toString() {
        return "Piece{" +
                "id=" + id +
                ", type=" + type +
                ", colour=" + colour +
                ", position=" + position +
                '}';
    }
}
