package piece;

import javax.swing.ImageIcon;

import board.ChessBoard;
import chess.Piece;
import chess.Player;
import chess.Square;


/**
 * King clas extend piece
 * @author Chen,Wenqiang(Ivan) A00871834 Set 2A
 * @version Mar 17, 2019
 */
public class King extends Piece {
    /**
     * king constructor
     * 
     * @param x     x coordinate of king
     * @param y     y coordinate of king
     * @param color color of king
     */
    public King(int x, int y, int color) {
        super(x, y, color);
        //for output with jar file
        java.net.URL bimgURL = Bishop.class.getResource("/icons/bKing.png");    
        java.net.URL wimgURL = Bishop.class.getResource("/icons/wKing.png");    
        setIcon(color,new ImageIcon(bimgURL),new ImageIcon(wimgURL)); 
    //    setIcon(color, "icons/bKing.png", "icons/wKing.png");
    }

    /**
     * to check if king move valid
     * if king move in the same board ,the same movement as regular chess board 
     * as King can only move in any direction one step
     * king can only move up or down one board
     */
    @Override
    protected boolean validMove(int curX, int curY, int destX, int destY, ChessBoard curChessBoard,
            ChessBoard destChessBoard) {
        int boarddiff=Math.abs(curChessBoard.getBoardNo() - destChessBoard.getBoardNo());
        int moveXStep = Math.abs(destX - curX);
        int moveYStep = Math.abs(destY - curY);
        if(boarddiff==0||boarddiff==1) {
            if ((moveXStep == 1 || moveXStep == 0) && (moveYStep == 0 || moveYStep == 1)) {
                return true;
            }

        }
        return false;
    }

}
