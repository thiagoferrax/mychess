package com.thiagoferraz.mychess.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiagoferraz.mychess.domain.ChessBoard;
import com.thiagoferraz.mychess.domain.Piece;
import com.thiagoferraz.mychess.domain.PieceColour;
import com.thiagoferraz.mychess.domain.PieceType;

@RestController
@RequestMapping("/chessboard")
public class ChessBoardController {

		@GetMapping(path="/new", produces = "application/json")
		public ChessBoard getANewChessBoard() {
			ChessBoard board = new ChessBoard();
			
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
}
