package piece;



import board.ChessBoard;
import chess.Piece;


/**
 * Bishop class extend piece
 * @author Chen,Wenqiang(Ivan) A00871834 Set 2A
 * @version Mar 17, 2019
 */
public class Bishop extends Piece {
    /**
     * bishop constructor
     * @param x x coordinate of bishop
     * @param y y coordinate of bishop
     * @param color color of bishop
     */
    public Bishop(int x, int y,int color) {
        super(x, y,color);
        setIcon(color,"icons/bBishop.png","icons/wBishop.png");      
    }
    /**
     * to check if a bishop can move diagonally
     * if bishop move in the same board , the movement is the same as regular chess board movement
     * if bishop move up or down one board(one step),it can move one step diagonal 
     * if bishop move up or down two board(two step),it can move two step diagonal 
     */

    @Override
    protected boolean validMove(int curX, int curY, int destX, int destY, ChessBoard curChessBoard,
            ChessBoard destChessBoard) {

            return moveDiagonal(curX, curY, destX, destY, curChessBoard,destChessBoard);
        
    }
   

 


   
}
