package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
           try {
               Ui.clearScreen();
               Ui.pirntMatch(chessMatch);
               System.out.println();
               System.out.print("Source: ");
               ChessPosition source = Ui.readChessPosition(sc);

               boolean[][] possibleMoves = chessMatch.possibleMoves(source);
               Ui.clearScreen();
               Ui.printBoard(chessMatch.getPieces(), possibleMoves);


               System.out.println();
               System.out.print("Target: ");
               ChessPosition target = Ui.readChessPosition(sc);

               ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
           } catch (ChessException | InputMismatchException e) {
               System.out.println(e.getMessage());
               sc.nextLine();
           }
        }




        }
    }
