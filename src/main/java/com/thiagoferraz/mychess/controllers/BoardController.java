package com.thiagoferraz.mychess.controllers;

import com.thiagoferraz.mychess.domain.entities.Board;
import com.thiagoferraz.mychess.domain.entities.Move;
import com.thiagoferraz.mychess.domain.entities.Piece;
import com.thiagoferraz.mychess.domain.entities.Position;
import com.thiagoferraz.mychess.domain.enums.PieceColour;
import com.thiagoferraz.mychess.domain.enums.PieceType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chessboard")
public class BoardController {
		Board board = new Board();

		@GetMapping(path="/new", produces = "application/json")
		public Board getANewChessBoard() {

			board.addPiece(new Piece(PieceType.Rook, PieceColour.White, 0, 0));
			board.addPiece(new Piece(PieceType.Knight, PieceColour.White, 1, 0));
			board.addPiece(new Piece(PieceType.Bishop, PieceColour.White, 2, 0));
			board.addPiece(new Piece(PieceType.King, PieceColour.White, 3, 0));
			board.addPiece(new Piece(PieceType.Queen, PieceColour.White, 4, 0));
			board.addPiece(new Piece(PieceType.Bishop, PieceColour.White, 5, 0));
			board.addPiece(new Piece(PieceType.Knight, PieceColour.White, 6, 0));
			board.addPiece(new Piece(PieceType.Rook, PieceColour.White, 7, 0));

			board.addPiece(new Piece(PieceType.Pawn, PieceColour.White, 0, 1));
			board.addPiece(new Piece(PieceType.Pawn, PieceColour.White, 1, 1));
			board.addPiece(new Piece(PieceType.Pawn, PieceColour.White, 2, 1));
			board.addPiece(new Piece(PieceType.Pawn, PieceColour.White, 3, 1));
			board.addPiece(new Piece(PieceType.Pawn, PieceColour.White, 4, 1));
			board.addPiece(new Piece(PieceType.Pawn, PieceColour.White, 5, 1));
			board.addPiece(new Piece(PieceType.Pawn, PieceColour.White, 6, 1));
			board.addPiece(new Piece(PieceType.Pawn, PieceColour.White, 7, 1));
			
			board.addPiece(new Piece(PieceType.Pawn, PieceColour.Black, 0, 6));
			board.addPiece(new Piece(PieceType.Pawn, PieceColour.Black, 1, 6));
			board.addPiece(new Piece(PieceType.Pawn, PieceColour.Black, 2, 6));
			board.addPiece(new Piece(PieceType.Pawn, PieceColour.Black, 3, 6));
			board.addPiece(new Piece(PieceType.Pawn, PieceColour.Black, 4, 6));
			board.addPiece(new Piece(PieceType.Pawn, PieceColour.Black, 5, 6));
			board.addPiece(new Piece(PieceType.Pawn, PieceColour.Black, 6, 6));
			board.addPiece(new Piece(PieceType.Pawn, PieceColour.Black, 7, 6));

			board.addPiece(new Piece(PieceType.Rook, PieceColour.Black, 0, 7));
			board.addPiece(new Piece(PieceType.Knight, PieceColour.Black, 1, 7));
			board.addPiece(new Piece(PieceType.Bishop, PieceColour.Black, 2, 7));
			board.addPiece(new Piece(PieceType.King, PieceColour.Black, 3, 7));
			board.addPiece(new Piece(PieceType.Queen, PieceColour.Black, 4, 7));
			board.addPiece(new Piece(PieceType.Bishop, PieceColour.Black, 5, 7));
			board.addPiece(new Piece(PieceType.Knight, PieceColour.Black, 6, 7));
			board.addPiece(new Piece(PieceType.Rook, PieceColour.Black, 7, 7));
			
			return board;
		}

		@PostMapping(path="/move", produces = "application/json")
		public Board move(@RequestBody Move move) {
			Position from = move.getFrom();
			Position to = move.getTo();
			board.move(from, to);
			return board;
		}
}
