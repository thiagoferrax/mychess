package com.thiagoferraz.mychess.game;

public enum GameStatus {
    ACTIVE(1, "Active"),
    ENDED(2, "Ended"),
    ABANDONED(3, "Abandoned"),
    DRAW(4, "Draw"),
    CHECKMATE(5, "Checkmate"),
    STALEMATE(6, "Stalemate"),
    RESIGNED(7, "Resigned"),
    TIME_EXPIRED(8, "Time Expired");

    private final Integer id;
    private final String description;

    GameStatus(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static GameStatus toEnum(Integer id) {
        for (GameStatus status : GameStatus.values()) {
            if (status.getId().equals(id)) {
                return status;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
