package com.thiagoferraz.mychess.model.entities;

import com.thiagoferraz.mychess.model.enums.GameStatus;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Game implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "GamePlayer", joinColumns = @JoinColumn(name = "gameId"), inverseJoinColumns = @JoinColumn(name = "playerId"))
    private List<Player> players = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "game")
    private Board board;
    private Date start;
    private Date end;

    public Game() {
    }

    public Game(Integer id, GameStatus status, Board board, Date start, Date end) {
        this.id = id;
        this.status = status.getId();
        this.board = board;
        this.start = start;
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public GameStatus getStatus() {
        return GameStatus.toEnum(status);
    }

    public void setStatus(GameStatus status) {
        this.status = status.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(players, game.players) && Objects.equals(board, game.board) && Objects.equals(start, game.start) && Objects.equals(end, game.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, players, board, start, end);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", board=" + board +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
