package piece;

import javax.swing.ImageIcon;

import board.ChessBoard;
import chess.Piece;
import chess.Player;
import chess.Square;

/**
 * Rook class extends piece
 * @author Chen,Wenqiang(Ivan) A00871834 Set 2A
 * @version Mar 17, 2019
 */
public class Rook extends Piece {
    /**
     * Rook constructor
     * @param x x coordinate of rook
     * @param y  y coordinate of rook
     * @param color color of rook
     */
    public Rook(int x, int y, int color) {
        super(x, y, color);
        //for output with jar file
        java.net.URL bimgURL = Bishop.class.getResource("/icons/bRook.png");    
        java.net.URL wimgURL = Bishop.class.getResource("/icons/wRook.png");    
        setIcon(color,new ImageIcon(bimgURL),new ImageIcon(wimgURL)); 
    //    setIcon(color, "icons/bRook.png", "icons/wRook.png");
    }
    /**
     * to check if rook move valid
     * if rook move in the same board, regular chess movement
     * if rook move up or down one  board(it move one step),
     * in dennis example ,it can only move up or down vertically
     * it rook move up or down  two board(it move two step)
     */
    @Override
    protected boolean validMove(int curX, int curY, int destX, int destY, ChessBoard curChessBoard,
            ChessBoard destChessBoard) {
     
            return move_Hor_Ver(curX, curY, destX, destY, curChessBoard,destChessBoard);
            
      
    }
    



}
