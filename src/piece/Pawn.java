package piece;

import board.ChessBoard;
import chess.Piece;
import chess.Player;
import chess.Square;
/**
 * Pawn class extend piece
 * @author Chen,Wenqiang(Ivan) A00871834 Set 2A
 * @version Mar 17, 2019
 */
public class Pawn extends Piece {
    private boolean isFirstMove;

    /**
     * Pawn constructor
     * 
     * @param x     x coordinate of pawn
     * @param y     y coordinate of pawn
     * @param color color of pawn
     */
    public Pawn(int x, int y, int color) {
        super(x, y, color);
        setIcon(color, "icons/bPawn.png", "icons/wPawn.png");
        isFirstMove = true;
    }

  

    /**
     * to check Ydirection based on pawn's color
     * 
     * @return 1 if black pawn -1 if white pawn
     */
    private int checkYdirection() {

        int direction = 1;
        if (this.color == Player.WHITE) {
            direction = -1;
        }
        return direction;

    }

    /**
     * 
     * the rule for pawn
     * if it is move on the same board , the same as regular chess board move
     * it can move up or down one board(it mean move one step), it is valid 
     * if it is move up or down two board(it mean move two step) , this only for first move 
     */
    @Override
    protected boolean validMove(int curX, int curY, int destX, int destY, ChessBoard curChessBoard,
            ChessBoard destChessBoard) {
        int boarddiff=Math.abs(curChessBoard.getBoardNo() - destChessBoard.getBoardNo());
        int twoStep = 2 * checkYdirection();
        int oneStep = 1 * checkYdirection();
        
        if (destX != curX||Math.abs(destY - curY) > 2) {
            return false;
        }
        
        
        if (boarddiff==0) {
            Square[][] squares = destChessBoard.getSquares();

            if (isFirstMove && destY == curY + twoStep) {
                if (!squares[curX][curY + oneStep].isOccupied()) {
                    isFirstMove = false;
                    return true;
                }
                return false;
            } 
            
            if (isValidOneStep(destY,curY,oneStep)) {             
                return true;
            }
            
        } 
        
        if (boarddiff == 1) {          
            if (isValidOneStep(destY,curY,oneStep)) {          
                return true;
            }
        }
        
        if(boarddiff == 2) {
            if (isFirstMove && destY == curY + twoStep) {        
                    isFirstMove = false;
                    return true;       
            }
           
        }
        
        return false;
    }
    
    /**
     * to check if the one step move is valid
     * @param destY dest y position of pawn
     * @param curY cur y position of pawn
     * @param oneStep one step for white pawn or black pawn
     * @return true if the movement is valid false otherwise
     */
    private boolean isValidOneStep(int destY, int curY, int oneStep) {
        if (destY == curY + oneStep) {
            isFirstMove = false;
            return true;
        }
        return false;
        
    }

 
}
