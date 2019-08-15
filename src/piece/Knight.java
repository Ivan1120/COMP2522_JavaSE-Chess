package piece;

import javax.swing.ImageIcon;

import board.ChessBoard;
import chess.Piece;
import chess.Player;
import chess.Square;


/**
 * Knight class extends Piece
 * @author Chen,Wenqiang(Ivan) A00871834 Set 2A
 * @version Mar 17, 2019
 */
public class Knight extends Piece {
    /**
     * Knight Constructor
     * 
     * @param x     x coordinate of knight
     * @param y     y coordinate of knight
     * @param color color of knight
     */
    public Knight(int x, int y, int color) {
        super(x, y, color);
        //for output with jar file
//        java.net.URL bimgURL = Bishop.class.getResource("/icons/bKnight.png");    
//        java.net.URL wimgURL = Bishop.class.getResource("/icons/wKnight.png");    
//        setIcon(color,new ImageIcon(bimgURL),new ImageIcon(wimgURL)); 
        setIcon(color, "icons/bKnight.png", "icons/wKnight.png");
    }

    /**
     * to check if a knight move valid
     * as in dennis demo,
     * knight can move up or down one board or two board in 2:1 or 1:2 movement
     */
    @Override
    protected boolean validMove(int curX, int curY, int destX, int destY, ChessBoard curChessBoard,
            ChessBoard destChessBoard) {
        int moveXStep = Math.abs(destX - curX);
        int moveYStep = Math.abs(destY - curY);

        if ((moveXStep == 2 && moveYStep == 1) || moveXStep == 1 && moveYStep == 2) {
            return true;
        }

        return false;

    }

}
