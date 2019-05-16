package chess;

import java.io.Serializable;

import board.ChessBoard;


/**
 * Square class has x,y coordinate on the board and also contain piece
 * @author Chen,Wenqiang(Ivan) A00871834 Set 2A
 * @version Mar 17, 2019
 */
public class Square implements Serializable {
    private int x;
    private int y;
    private Piece piece;
    
    private ChessBoard chessBoard;

    /**
     * Square constructor
     * @param chessBoard the chessboard square on
     * @param x the x coordinate of square
     * @param y the y coordinate of square
     */
    public Square(ChessBoard chessBoard, int x, int y) {
        this.chessBoard=chessBoard;
        this.x = x;
        this.y = y;

    }

    /**
     * Piece occupy square
     * 
     * @param piece the piece on the square
     */
    public void occupySpot(Piece piece) {
        this.piece = piece;
        piece.updatePosition(x, y);

    }
    /**
     * clear the piece on the square
     */
    public void releaseSpot() {
        this.piece = null;
    }
    
    /**
     * to check if a square is occupied by a piece
     * 
     * @return true if has piece ,false otherwise
     */
    public boolean isOccupied() {
        if (piece != null)
            return true;
        return false;
    }

   
    /**
     * Piece Getter
     * 
     * @return current price of this square
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * x coordinate getter
     * 
     * @return x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * x coordinate setter
     * 
     * @param x the x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * y coordinate getter
     * 
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * y coordinate setter
     * 
     * @param y the y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * chessBoard getter
     * @return chessboard
     */
    public ChessBoard getChessBoard() {
        return chessBoard;
    }
    /**
     * chessboard setter
     * @param chessBoard the chessboard to set
     */
    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }
    
    

}
