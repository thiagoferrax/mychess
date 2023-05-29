package com.thiagoferraz.mychess.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChessBoard implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Piece> pieces = new ArrayList<>();
	
	public List<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}

	public void addPiece(Piece piece) {
		pieces.add(piece);
	}
}
