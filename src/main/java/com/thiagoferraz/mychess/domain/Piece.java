package com.thiagoferraz.mychess.domain;

import java.io.Serializable;

public class Piece implements Serializable {

	private static final long serialVersionUID = 1L;

	private PieceType type;
	private PieceColour colour;
	private PiecePosition position;
	
	public Piece(PieceType type, PieceColour colour, int x, int y) {
		super();
		this.type = type;
		this.colour = colour;
		this.position = new PiecePosition(x, y);
	}
	
	public PieceColour getColour() {
		return colour;
	}
	public void setColour(PieceColour colour) {
		this.colour = colour;
	}
	
	public PieceType getType() {
		return type;
	}
	public void setType(PieceType type) {
		this.type = type;
	}
	
	public PiecePosition getPosition() {
		return position;
	}

	public void setPosition(PiecePosition position) {
		this.position = position;
	}

}
