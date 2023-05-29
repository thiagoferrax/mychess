package com.thiagoferraz.mychess.domain;

import java.io.Serializable;

public class Piece implements Serializable {

	private static final long serialVersionUID = 1L;

	private PieceType type;
	private PieceColour colour;
	private int x;
	private int y;
	
	public Piece(PieceType type, PieceColour colour, int x, int y) {
		super();
		this.type = type;
		this.colour = colour;
		this.x = x;
		this.y = y;
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
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
