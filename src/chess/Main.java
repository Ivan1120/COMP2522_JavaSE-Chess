package chess;


import board.*;

/**
 * The main class initalize board ,gui and two player
 * and start game
 * 
 * !!!Please run this game on desktop 
 * 
 * @author Chen,Wenqiang(Ivan) A00871834 Set 2A
 * @version Mar 17, 2019
 */
public class Main {
    public static void main(String[] args) {
        Player p1= new Player(Player.BLACK);
        Player p2 =new Player(Player.WHITE);
        
        //option 1: if run the below two code,3d chessboard init
        Gui gui = new Gui(3);
        Board board =new ChessBoard3D(gui,p1,p2);
        //option2 if run the below two code, regular chessboard init 
//        Gui gui = new Gui();
//         
//        Board board =new ChessBoard(gui,p1,p2);
        
        
        board.getCurBoard().initPieceOnBoard(p1);
        board.getCurBoard().initPieceOnBoard(p2);
        gui.runGui(board);
        
        board.showGui();
        
    }
    
    
}

