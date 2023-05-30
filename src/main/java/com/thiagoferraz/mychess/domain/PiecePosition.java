package com.thiagoferraz.mychess.domain;

import java.io.Serializable;
import java.util.Objects;

public class PiecePosition implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
	public PiecePosition(int x, int y) {
		super();
		this.x = x;
		this.y = y;
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

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PiecePosition other = (PiecePosition) obj;
		return x == other.x && y == other.y;
	}
	
	
}