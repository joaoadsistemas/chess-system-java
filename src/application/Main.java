package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (!chessMatch.getCheckMate()) {
           try {
               Ui.clearScreen();
               Ui.printMatch(chessMatch, captured);
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

               if (capturedPiece != null) {
                   captured.add(capturedPiece);
               }

           } catch (ChessException | InputMismatchException e) {
               System.out.println(e.getMessage());
               sc.nextLine();
           }
        }
        Ui.clearScreen();
        Ui.printMatch(chessMatch, captured);




        }
    }
