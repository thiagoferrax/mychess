package com.thiagoferraz.mychess.game;

import com.thiagoferraz.mychess.chessboard.Chessboard;
import com.thiagoferraz.mychess.player.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private Chessboard chessboard;

    private Date start;

    private Date end;

    public GameStatus getStatus() {
        return GameStatus.toEnum(status);
    }

    public void setStatus(GameStatus status) {
        this.status = status != null ? status.getId() : null;
    }

}
