package com.thiagoferraz.mychess.model.enums;

public enum PieceColour {
    White(0, "White"), Black(1, "Black");

    private final Integer id;
    private final String name;

    PieceColour(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static PieceColour toEnum(Integer id) {
        for (PieceColour colour : PieceColour.values()) {
            if (colour.getId().equals(id)) {
                return colour;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
