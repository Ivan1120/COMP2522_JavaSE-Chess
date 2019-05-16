package chess;

import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import board.ChessBoard;


/**
 * Piece class
 * @author Chen,Wenqiang(Ivan) A00871834 Set 2A
 * @version Mar 17, 2019
 */
public abstract class Piece implements Serializable {
    private int x;
    private int y;
    protected int color; 
    protected Icon pieceIcon;

    /**
     * Piece Constructor
     * 
     * @param x     x coordinate of piece
     * @param y     y coordinate of piece
     * @param color the color of piece
     */
    public Piece(int x, int y, int color) {
        setX(x);
        setY(y);
        setColor(color);
        this.pieceIcon = null;

    }



    /**
     * 
     * @param curX    the x coordinate of the piece
     * @param curY    the y coordinate of the piece
     * @param destX   the x coordinate of dest square
     * @param destY   the y coordinate of dest square
     * @param curChessBoard the curchessboard
     * @param destChessBoard the destchessboard
     * @return true if valid move ,false otherwise
     */
    protected abstract boolean validMove(int curX, int curY, int destX, int destY, ChessBoard curChessBoard,
            ChessBoard destChessBoard);
    /**
     * to check if other piece block the current moving piece in the way
     * 
     * @param squares the squares the board use
     * @param dirX    the x direction move from current x to dest x
     * @param dirY    the y direction move from current y to dest y
     * @param curX    the x coordinate of the piece
     * @param curY    the y coordinate of the piece
     * @param destX   the x coordinate of dest square
     * @param destY   the y coordinate of dest square
     * @return true if no other piece block the way,false otherwise
     */
    protected boolean isNoBlock(Square[][] squares, int dirX, int dirY, int curX, int curY, int destX, int destY) {

        while (destY != curY + dirY || destX != curX + dirX) {
            curY += dirY;
            curX += dirX;

            if (squares[curX][curY].isOccupied()) {
                return false;
            }
        }
        return true;
    }
    

    /**
     * to check if a piece can move horiontally or vertically
     * @param curX    the x coordinate of the piece
     * @param curY    the y coordinate of the piece
     * @param destX   the x coordinate of dest square
     * @param destY   the y coordinate of dest square
     * @param curChessBoard the curchessboard
     * @param destChessBoard the destchessboard
     * @return true if if can move horiontally or vertically ,false otherwise
     */
    protected boolean move_Hor_Ver(int curX, int curY, int destX, int destY, ChessBoard curChessBoard,
            ChessBoard destChessBoard) {
        int boarddiff=Math.abs(curChessBoard.getBoardNo() - destChessBoard.getBoardNo());
      
        boolean isMoveHor = ((curX == destX) && (curY != destY));
        boolean isMoveVer = ((curX != destX) && (curY == destY));
        int dirX = checkXdirection(curX, destX);
        int dirY = checkYdirection(curY, destY);
        if (isMoveHor || isMoveVer) {
            if(boarddiff==0) {
                Square[][] squares=destChessBoard.getSquares();
                return isNoBlock(squares, dirX, dirY, curX, curY, destX, destY);
     
            }
            if(boarddiff==1&&destY==curY+dirY) {  
                  return true;    
            }
            if(boarddiff==2) {  
                if(dirY!=0&&destY==curY+dirY*2) {
                    
                    return true;    
                }
               
          }
                  
        }
        return false;
    }
    
   
    /**
     * 
     * @param curX    the x coordinate of the piece
     * @param curY    the y coordinate of the piece
     * @param destX   the x coordinate of dest square
     * @param destY   the y coordinate of dest square
     * @param curChessBoard  the curchessboard
     * @param destChessBoard  the destchessboard
     * @return true if can move diagonal ,false otherwise
     */
    protected boolean moveDiagonal(int curX, int curY, int destX, int destY, ChessBoard curChessBoard,
            ChessBoard destChessBoard) {
        int boarddiff=Math.abs(curChessBoard.getBoardNo() - destChessBoard.getBoardNo());
        int dirX = checkXdirection(curX, destX);
        int dirY = checkYdirection(curY, destY);
        if (Math.abs(curX - destX) == Math.abs(curY - destY)) {
            if(boarddiff==0) {
                Square[][] squares=destChessBoard.getSquares();
                return isNoBlock(squares, dirX, dirY, curX, curY, destX, destY);
            }
            if(boarddiff==1&&destY==curY+dirY&&destX==curX+dirX) {
                return true;
            }
            if(boarddiff==2&&destY==curY+dirY*2&&destX==curX+dirX*2) {
                return true;
            }
            
            
        }
        return false;
        
        
    }
    /**
     * to check if y move north, south or no move
     * @param curY the curY of the piece
     * @param destY the destY of the piece move to
     * @return -1 if move north,1 is move south,0 is no move
     */
    protected int checkYdirection(int curY, int destY) {
        
        if (curY > destY) {
            return -1;
        } else if (curY < destY) {
            return 1;
        } else {
            return 0;
        }
    }
    /**
     *to check if x move east, west or no move
     * @param curX the curX of the piece
     * @param destX the destX of the piece move to
     * @return -1 if move east,1 is move west,0 is no move
     */
    public int checkXdirection(int curX, int destX) {
        if (curX > destX) {
            return -1;
        } else if (curX < destX) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * update piece position after move piece
     * 
     * @param x the new x coordiante of piece
     * @param y the new y coordiante of piece
     */
    public void updatePosition(int x, int y) {
        this.setX(x);
        this.setY(y);

    }

    /**
     * x coordinate getter
     * 
     * @return x coordinate of piece
     */
    public int getX() {
        return x;
    }

    /**
     * x coorindate setter
     * 
     * @param x x coordinate of piece
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * y coordinate getter
     * 
     * @return y coordinate of piece
     */
    public int getY() {
        return y;
    }

    /**
     * y coorindate setter
     * 
     * @param y y coordinate of piece
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Initialize the pieceIcon of piece
     * 
     * @param color the color of piece
     * @param bPic  the pieceIcon of black player
     * @param wPic  the pieceIcon of white player
     */
    public void setIcon(int color, String bPic, String wPic) {
        switch (color) {
        case Player.WHITE:
            pieceIcon = new ImageIcon(wPic);
            break;

        case Player.BLACK:
            pieceIcon = new ImageIcon(bPic);
            break;
        }
    };

    /**
     * PieceIcon getter
     * 
     * @return the piece's icon image
     */
    public Icon getIcon() {
        return pieceIcon;
    }

    /**
     * color getter
     * 
     * @return the color of the piece
     */
    public int getColor() {
        return color;
    }

    /**
     * color setter
     * 
     * @param color the color of piece of set
     */
    public void setColor(int color) {
        this.color = color;
    }


  

}
