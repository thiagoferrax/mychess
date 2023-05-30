package com.thiagoferraz.mychess.domain.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Board implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Map<Position, Piece> pieces = new HashMap<>();
	
	public Collection<Piece> getPieces() {
		return pieces.values();
	}

	public void setPieces(Map<Position, Piece> pieces) {
		this.pieces = pieces;
	}

	public void addPiece(Piece piece) {
		pieces.put(piece.getPosition(),  piece);
	}
	
	public void move(Position from, Position to) {
		Piece piece = pieces.get(from);
		piece.setPosition(to);
		pieces.put(to, piece);
	}
}
