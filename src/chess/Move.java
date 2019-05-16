package chess;

import java.io.Serializable;

import board.ChessBoard;

/**
 * Move class
 * @author Chen,Wenqiang(Ivan) A00871834 Set 2A
 * @version Mar 17, 2019
 */
public class Move implements Serializable {
    private boolean isPickPiece;
    private Piece currentPiece;

    private int turn;

    private int curX;
    private int curY;
    private int destX;
    private int destY;
    
    private ChessBoard curChessBoard;
    private ChessBoard destChessBoard;

    

    /**
     * Move constructor initialize square ,isPickPiece,and turn
     * 
     * @param squares
     */
    public Move() {
        isPickPiece = true;
        turn = Player.BLACK;
    }


    
    /**
     * 
     * @param chessBoard the piece of board on
     * @param x   x coordinate of user click
     * @param y   y coordinate of user click
     * @param gui the gui board use
     */
    public void move(ChessBoard chessBoard,int x, int y, Gui gui) {
        Square[][] squares=chessBoard.getSquares();
        if (isPickPiece) {
            if (squares[x][y].isOccupied()) {
                curX = x;
                curY = y;
                
                currentPiece = squares[curX][curY].getPiece();
                curChessBoard=chessBoard;
                if (currentPiece.getColor() == turn) {
                    isPickPiece = false;

                }
            }
        } else {
            destX = x;
            destY = y;
            if (!squares[destX][destY].isOccupied()) {
            	destChessBoard=chessBoard;
            	boolean isvalidMove=currentPiece.validMove(curX, curY, destX, destY, curChessBoard,destChessBoard);
                if (isvalidMove) {       	
                	gui.setPiece(destChessBoard.getSquares()[destX][destY], currentPiece);
                	gui.clearPiece(curChessBoard.getSquares()[destX][destY],currentPiece);

                	curChessBoard.getSquares()[curX][curY].releaseSpot();
                	destChessBoard.getSquares()[destX][destY].occupySpot(currentPiece);
                    changeTurn(turn);
                }
            }

            isPickPiece = true;
        }
    }


    /**
     * change turn
     * 
     * @param turn the turn of player
     */
    public void changeTurn(int turn) {
        this.turn = (turn == Player.BLACK) ? Player.WHITE : Player.BLACK;
    }

}
