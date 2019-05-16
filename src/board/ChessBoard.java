package board;

import java.io.Serializable;

import javax.swing.JButton;

import chess.Gui;
import chess.Piece;
import chess.Player;
import chess.Square;

/**
 * chessBoard class extend Board class 
 * @author Chen,Wenqiang(Ivan) A00871834 Set 2A
 * @version Mar 17, 2019
 */
public class ChessBoard extends Board implements Serializable {
  
    /**
     * Constructor of Board accept gui,player1,player2
     * initialize class move ,square and piece on board
     * 
     * @param gui the gui the board use
     * @param player1 the player1 the board use
     * @param player2 the player2 the board use
     */
    public ChessBoard(Gui gui, Player player1, Player player2) {
        super(gui, player1, player2);      
        initialSquare();
        curBoard=this;
    }
    
    /**
     * 
     * initial Squares
     */
    public void initialSquare() {
       
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                squares[i][j] = new Square(this,i, j);
            }
        }
    }
    /**
     * initial player's piece and put piece on board of gui
     * @param p the player to initialize
     */
    public void initPieceOnBoard(Player p) {
        Piece[] pieces = p.getPieces();

        for (int i = 0; i < pieces.length; i++) {
            int x = pieces[i].getX();
            int y = pieces[i].getY();
            squares[x][y].occupySpot(pieces[i]);
            gui.setPiece(squares[x][y], pieces[i]);
        }
    }
     
    /**
     * move piece on board
     */
    public void movePiece(int boardNo,int x, int y) {
        move.move(curBoard,x, y, gui);
    }

    /** 
     * reset board after load game
     */
    public void resetBoard() {
        initPieceOnBoard(player1);
        initPieceOnBoard(player2);    
    }
}
