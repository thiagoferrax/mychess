package com.thiagoferraz.mychess.domain.enums;

public enum PieceType {
	Pawn(1, "Pawn", "Each player starts with eight pawns, arranged on the second rank (for White) and seventh rank (for Black). Pawns have the most limited movement. They move forward one square, but capture diagonally. On their initial move, pawns can move two squares forward."),
	Knight(3, "Knight", "Each player starts with two knights. Knights have a unique movement pattern. They move in an L-shape, consisting of two squares in one direction (horizontally or vertically) and then one square in a perpendicular direction."), 
	Bishop(3, "Bishop", "Each player starts with two bishops. Bishops can move diagonally any number of squares, as long as there are no obstructions in their path. One bishop starts on a dark-colored square, and the other starts on a light-colored square."),
	Rook(5, "Rook", "Also known as a castle, each player starts with two rooks. Rooks can move horizontally and vertically any number of squares, as long as there are no obstructions in their path."),
	Queen(9, "Queen","The most powerful piece on the board. Each player starts with one queen. The queen can move horizontally, vertically, and diagonally in any direction."),
	King(100, "King","The most powerful piece on the board. Each player starts with one queen. The queen can move horizontally, vertically, and diagonally in any direction.");

	int points;
	String name;
	String description;
	
	PieceType(int points, String name, String description) {
		this.points = points;
		this.name = name;
		this.description = description;
	}
}
