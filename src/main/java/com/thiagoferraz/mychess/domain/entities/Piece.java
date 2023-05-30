package com.thiagoferraz.mychess.domain.entities;

import com.thiagoferraz.mychess.domain.enums.PieceColour;
import com.thiagoferraz.mychess.domain.enums.PieceType;

import java.io.Serializable;

public class Piece implements Serializable {

	private static final long serialVersionUID = 1L;

	private PieceType type;
	private PieceColour colour;
	private Position position;
	
	public Piece(PieceType type, PieceColour colour, int x, int y) {
		super();
		this.type = type;
		this.colour = colour;
		this.position = new Position(x, y);
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
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
