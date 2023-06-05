package com.thiagoferraz.mychess.model.enums;

public enum PieceColour {
    White(0, "White"), Black(1, "Black");

    private Integer id;
    private String name;

    private PieceColour(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static PieceColour toEnum(Integer id) {
        for(PieceColour colour : PieceColour.values()) {
            if(colour.getId().equals(id)) {
                return colour;
            }
        }
        return null;
    }
}
