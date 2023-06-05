package com.thiagoferraz.mychess.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Board implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    @OneToMany(mappedBy = "board")
    private List<Piece> pieces = new ArrayList<>();
    @OneToMany(mappedBy = "board")
    private List<Move> moves = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "gameId")
    @MapsId
    @JsonIgnore
    private Game game;

    public Board() {
    }

    public Board(Integer id, Game game) {
        this.id = id;
        this.game = game;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(id, board.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                '}';
    }
}
