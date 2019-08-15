package piece;

import javax.swing.ImageIcon;

import board.ChessBoard;
import chess.Piece;
import chess.Player;
import chess.Square;

/**
 * Queen class extends piece
 * @author Chen,Wenqiang(Ivan) A00871834 Set 2A
 * @version Mar 17, 2019
 */
public class Queen extends Piece {
    /**
     * Queen constructor
     * @param x x coordinate of queen
     * @param y y coordinate of queen
     * @param color color of queen
     */
    public Queen(int x, int y, int color) {
        super(x, y, color);
        //for output with jar file
//        java.net.URL bimgURL = Bishop.class.getResource("/icons/bQueen.png");    
//        java.net.URL wimgURL = Bishop.class.getResource("/icons/wQueen.png");    
//        setIcon(color,new ImageIcon(bimgURL),new ImageIcon(wimgURL)); 
        setIcon(color, "icons/bQueen.png", "icons/wQueen.png");
    }
    /**
     * to check if queen move valid
     * queen move the same like rook and bishop
     */
    @Override
    protected boolean validMove(int curX, int curY, int destX, int destY, ChessBoard curChessBoard,
            ChessBoard destChessBoard) {

           return move_Hor_Ver(curX, curY, destX, destY, curChessBoard,destChessBoard)
                   || moveDiagonal(curX, curY, destX, destY, curChessBoard,destChessBoard);

      
    }

}
