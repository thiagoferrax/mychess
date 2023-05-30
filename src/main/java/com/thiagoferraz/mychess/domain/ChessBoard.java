package com.thiagoferraz.mychess.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ChessBoard implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Map<PiecePosition, Piece> pieces = new HashMap<>();
	
	public Collection<Piece> getPieces() {
		return pieces.values();
	}

	public void setPieces(Map<PiecePosition, Piece> pieces) {
		this.pieces = pieces;
	}

	public void addPiece(Piece piece) {
		pieces.put(piece.getPosition(),  piece);
	}
	
	public void move(Piece piece, int x, int y) {
		pieces.remove(piece.getPosition());
		piece.setPosition(new PiecePosition(x, y));
		pieces.put(piece.getPosition(),  piece);
	}
}
