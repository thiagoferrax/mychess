package com.thiagoferraz.mychess.domain.entities;

public class Move {
    private Position from;
    private Position to;

    // Getters and setters

    public Position getFrom() {
        return from;
    }

    public void setFrom(Position from) {
        this.from = from;
    }

    public Position getTo() {
        return to;
    }

    public void setTo(Position to) {
        this.to = to;
    }
}
