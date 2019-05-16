package chess;

import java.io.Serializable;

import piece.Bishop;
import piece.King;
import piece.Knight;
import piece.Pawn;
import piece.Queen;
import piece.Rook;

/**
 * the player class contain piece
 * @author Chen,Wenqiang(Ivan) A00871834 Set 2A
 * @version Mar 17, 2019
 */
public class Player implements Serializable{
    public static final int BLACK =  1;
    public static final int WHITE = 2;
    private int color;
    private Piece[] pieces;
    private int pieceNumber;
    
    /**
     * initilize black player and white player
     * 
     * @param color the color of black or white
     */
    public Player(int color) {
        
        this.color = color;
        this.pieceNumber = 16;
        pieces = new Piece[pieceNumber];
        initializePieces();
    }

   
    /**
     * initialize Pieces
     */
    public void initializePieces() {
        int pawnsNumber = 8;
        switch (this.color) {
        case BLACK:
            pieces[0] = new Rook(0, 0,BLACK);

            pieces[1] = new Rook(7, 0,BLACK);
            pieces[2] = new Bishop(2, 0,BLACK);
            pieces[3] = new Bishop(5, 0,BLACK);
            pieces[4] = new Knight(1, 0,BLACK);
            pieces[5] = new Knight(6, 0,BLACK);
            pieces[6] = new Queen(3, 0,BLACK);
            pieces[7] = new King(4, 0,BLACK);
            for (int i = 0; i < pieceNumber; i++) { 
                if (i < 8) {
                    pieces[i + pawnsNumber] = new Pawn(i, 1,BLACK);
                }

            }
            break;

        case WHITE:
            pieces[0] = new Rook(0, 7,WHITE);
            pieces[1] = new Rook(7, 7,WHITE);
            pieces[2] = new Bishop(2, 7,WHITE);
            pieces[3] = new Bishop(5, 7,WHITE);
            pieces[4] = new Knight(1, 7,WHITE);
            pieces[5] = new Knight(6, 7,WHITE);
            pieces[6] = new Queen(3, 7,WHITE);
            pieces[7] = new King(4, 7,WHITE);
            for (int i = 0; i < pieceNumber; i++) { 
                if (i < 8) {
                    pieces[i + pawnsNumber] = new Pawn(i, 6,WHITE);
                }
              
            }
        }
      
    }

    /**
     * Piece Getter
     * 
     * @return the pieces of the player
     */
    public Piece[] getPieces() {
        return pieces;
    }

}
