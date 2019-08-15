package board;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.BorderFactory;

import chess.Gui;
import chess.Player;


/**
 * chessBoard3d class extend Board class 
 * @author Chen,Wenqiang(Ivan) A00871834 Set 2A
 * @version Mar 17, 2019
 */
public class ChessBoard3D extends Board implements Serializable {
   
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private ChessBoard[] board;
    
    /**
     * Constructor of Board accept gui,player1,player2 initialize class move ,square
     * and piece on board
     * 
     * @param gui     the gui the board use
     * @param player1 the player1 the board use
     * @param player2 the player2 the board use
     */
    public ChessBoard3D(Gui gui, Player player1, Player player2) {
        super(gui, player1, player2);
       
        board = new ChessBoard[3];
        for (int i = 0; i < board.length; i++) {
            board[i]=new ChessBoard(gui, player1, player2);
            board[i].boardNo=i;
        }
        curBoard = board[0];

    }

    /**
     * move piece on board
     */
    public void movePiece(int boardNo,int x, int y) {
    	move.move(board[boardNo],x, y, gui);
 
    }

}
