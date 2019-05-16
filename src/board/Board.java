package board;

import chess.Gui;
import chess.Move;
import chess.Player;
import chess.Square;

/**
 * The board class contain squares, gui ,two player and move it will initialize
 * player's piece and initialize square it will accept input from gui and pass
 * to move class to move piece on board
 * 
 * @author Chen,Wenqiang(Ivan) A00871834 Set 2A
 * @version Mar 17, 2019
 */
public abstract class Board {

    public static final int GRIDSIZE = 8;
    protected static final long serialVersionUID = 1L;

    protected Gui gui;
    protected Player player1;
    protected Player player2;
    protected Square[][] squares;
    protected Move move;

    protected int boardNo;
    protected ChessBoard curBoard;

    /**
     * Board constructor to initialize gui,player,squares,movehandler.
     * 
     * @param gui     the gui to use
     * @param player1 the player1 to use
     * @param player2 the player2 to use
     */
    public Board(Gui gui, Player player1, Player player2) {
        this.gui = gui;
        this.player1 = player1;
        this.player2 = player2;
        squares = new Square[GRIDSIZE][GRIDSIZE];
        move = new Move();
    }

    
    /**
     * default constructor
     */
    public Board() {

    }
    
    /**
     * move piece
     * 
     * @param boardNo the boardNo the board use
     * @param x the x position of the square player click
     * @param y the y position of the square player click
     */
    public abstract void movePiece(int boardNo, int x, int y);
    
    /**
     * set gui to visiable
     */
    public void showGui() {
        gui.setVisible(true);
    }

    /**
     * Gui getter
     * 
     * @return the gui
     */
    public Gui getGui() {
        return gui;
    }

    /**
     * Gui setter
     * 
     * @param gui the gui to set
     */
    public void setGui(Gui gui) {
        this.gui = gui;
    }

    /**
     * Player2(White Player) getter
     * 
     * @return white player
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Player2(white player) setter
     * 
     * @param player2 the white player to set
     */
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    /**
     * Squares getter
     * 
     * @return the squares on the board
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     * Squares setter
     * 
     * @param squares the squares to set
     */
    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    /**
     * curBoard getter
     * 
     * @return curBoard the curboard to set
     */
    public ChessBoard getCurBoard() {
        return curBoard;
    }

    /**
     * curBoard setter
     * 
     * @param curBoard the curboard to set
     */
    public void setCurBoard(ChessBoard curBoard) {
        this.curBoard = curBoard;
    }
    /**
     * BoardNo getter
     * @return  BoardNo
     */
    public int getBoardNo() {
        return boardNo;
    }
    /**
     * BoardNo setter
     * @param boardNo the boardNo to set
     */
    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

}
