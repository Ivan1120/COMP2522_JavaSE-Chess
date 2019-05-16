package chess;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import board.Board;
import board.ChessBoard;


/**
 * The gui class control game ui it contain class board
 * @author Chen,Wenqiang(Ivan) A00871834 Set 2A
 * @version Mar 17, 2019
 */
public class Gui extends JFrame implements Serializable {
    // for 3d chessboard
    private JButton[][][] jbtn3DArr;
    private JPanel[] mySJPanels;

    // for regular chessboard
    private JButton[][] jbtnArr;

    // for regular chessboard and 3d chessboard
    private Board board;
    private JPanel myJPanel;

    // for gui window
    public static final int screenWidth = 800; // screen width in pixels
    public static final int screenHeight = 800; // screen height in pixels
    public static final String defualtTitle = "chessGame";

    // for menu
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem saveButton;
    private JMenuItem loadButton;

    /**
     * Regular chessboard GUI constructor 1.commons gui setting 2.initial jtbnArr
     * 3.draw Square of the board on gui
     */
    public Gui() {
        commonSet();
        jbtnArr = new JButton[ChessBoard.GRIDSIZE][ChessBoard.GRIDSIZE];
        drawSquare(myJPanel, jbtnArr, "0");
    }

    /**
     * 3D ChessBoard Gui constructor 1.commons gui setting 2.initial jbtn3DArr and
     * mySJPanels 3.draw Square of the board
     * 
     * @param n the number of chessboard to set
     */
    public Gui(int n) {
        commonSet();
        jbtn3DArr = new JButton[n][ChessBoard.GRIDSIZE][ChessBoard.GRIDSIZE];

        mySJPanels = new JPanel[n];
        for (int i = 0; i < mySJPanels.length; i++) {
            mySJPanels[i] = new JPanel();
            mySJPanels[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            drawSquare(mySJPanels[i], jbtn3DArr[i], i + "");
            myJPanel.add(mySJPanels[i]);
        }
        myJPanel.setLayout(new GridLayout(1, 3));

    }

    /**
     * common setting for 1.gui window 2.gui menu 3.initial myJPanel and basic
     * layout
     * 
     */
    public void commonSet() {
        setWindow();
        initMenu();
        myJPanel = new JPanel();
        getContentPane().add(myJPanel);
    }

    /**
     * initMenu
     */
    private void initMenu() {
        this.menuBar = new JMenuBar();
        this.menu = new JMenu("File");
        this.saveButton = new JMenuItem("Save");
        this.loadButton = new JMenuItem("Load");
        this.saveButton.addActionListener(new MenuHandler());
        this.loadButton.addActionListener(new MenuHandler());
        menu.add(saveButton);
        menu.add(loadButton);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    /**
     * to accept board to use
     * 
     * @param board the board the gui use
     */
    public void runGui(Board board) {
        this.board = board;
    }

    /**
     * set the basic layout about the game ui window
     */
    private void setWindow() {
        this.setTitle(defualtTitle);
        this.setSize(screenWidth, screenHeight);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    /**
     * use gui to draw square on the board initialize jbutton and set color of
     * jbutton add listener to jbutton
     * 
     * @param myJPanelsPam the myJPanelsPam for each board
     * @param jbtnArrPam   the jbtnArrPam for each board
     * @param boardNo      the boardno(0,1,2) to set on each jbtnArr
     */
    private void drawSquare(JPanel myJPanelsPam, JButton[][] jbtnArrPam, String boardNo) {
        myJPanelsPam.setLayout(new GridLayout(8, 8));
        String black = "#D3D3D3";
        String white = "#FFFFFF";
        boolean isBlackSquare = true;

        for (int i = 0; i < jbtnArrPam.length; i++) {
            for (int j = 0; j < jbtnArrPam[0].length; j++) {
                jbtnArrPam[i][j] = new JButton();
                jbtnArrPam[i][j].setName(boardNo); // each jtbn has a boardno(0,1,2)
                if (isBlackSquare) {
                    jbtnArrPam[i][j].setBackground(Color.decode(black));

                } else {
                    jbtnArrPam[i][j].setBackground(Color.decode(white));
                }

                myJPanelsPam.add(jbtnArrPam[i][j]);

                jbtnArrPam[i][j].addActionListener(new MoveHandler());
                isBlackSquare = !isBlackSquare;
            }
            isBlackSquare = !isBlackSquare;
        }

    }

    /**
     * MenuHandler
     */
    private class MenuHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
            case "Save":
                save();
                break;
            case "Load":
                load();
                break;
            }

        }

        /**
         * save File name
         * 
         * @return the file name to save
         */
        private String saveFileName() {
            JFileChooser fc = new JFileChooser();
            int option = fc.showSaveDialog(null);
            String fileName = "";
            if (option == JFileChooser.APPROVE_OPTION) {
                fileName = fc.getSelectedFile().getAbsolutePath();

            }
            return fileName;
        }

        /**
         * save chess board to file
         */
        private void save() {
            String fileName = saveFileName();
            try {
                FileOutputStream fileOut = new FileOutputStream(fileName);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(board);
                out.close();
                fileOut.close();
                System.out.println("Game saved to " + fileName);
            } catch (IOException i) {
            }
        }

    }

    /**
     * loadFileName
     * 
     * @return the file name to load
     */
    private String loadFileName() {
        JFileChooser fc = new JFileChooser();
        String fileName = "";
        int option = fc.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            fileName = fc.getCurrentDirectory() + File.separator + fc.getSelectedFile().getName();
        }
        return fileName;
    }

    /**
     * Load Board from file
     */
    private void load() {
        String fileName = loadFileName();
        try {
            FileInputStream fileIn = new FileInputStream(fileName);

            ObjectInputStream in = new ObjectInputStream(fileIn);
            ChessBoard board = (ChessBoard) in.readObject();

            in.close();
            fileIn.close();
            board.setGui(this);
            resetBoard();
            board.resetBoard();

        } catch (IOException i) {
            System.out.println("Error reading file");
        } catch (ClassNotFoundException c) {
            System.out.println("Invalid save file");
        }

    }

    /**
     * to clear all piece on all jbutton
     */
    private void resetBoard() {
        for (int i = 0; i < jbtnArr.length; i++) {
            for (int j = 0; j < jbtnArr[0].length; j++) {
                jbtnArr[i][j].setIcon(null);
            }
        }
    }

    /**
     * Move handler accept user mouse click to pass to board
     */
    private class MoveHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton jButton;
            int x;
            int y;
            // because regular board and 3d board on desktop screen, resolution is different
            // need to make some change
            if (isRegularBoard()) {

                int jButtonWidth = 98;
                int jButtonHeight = 92;
                jButton = (JButton) e.getSource();
                x = ((int) (jButton.getLocation().getX() / jButtonWidth));
                y = (int) (jButton.getLocation().getY() / jButtonHeight);

            } else {

                int jButtonWidth = 32;
                int jButtonHeight = 92;
                jButton = (JButton) e.getSource();
                x = ((int) (jButton.getLocation().getX()));
                y = (int) (jButton.getLocation().getY());
                if (x == 4) {
                    x = 0;
                } else {
                    x = (x - 4) / jButtonWidth;
                }
                if (y == 1) {
                    y = 0;
                } else {
                    y = (y - 1) / jButtonHeight;
                }

            }
            System.out.println("x: " + x + "y: " + y);
            int boardNo = Integer.parseInt(jButton.getName());

            board.movePiece(boardNo, x, y);

        }
    }

    /**
     * put piece's icon on the responding square
     * 
     * @param square the square the piece on
     * @param piece  the icon of which piece use
     */
    public void setPiece(Square square, Piece piece) {

        if (isRegularBoard()) {
            jbtnArr[square.getY()][square.getX()].setIcon(piece.getIcon());
        } else {
            jbtn3DArr[square.getChessBoard().getBoardNo()][square.getY()][square.getX()].setIcon(piece.getIcon());
        }

    }

    /**
     * clear piece's icon on previous square
     * 
     * @param square the square the piece on
     * @param piece  the piece to clear icon
     */
    public void clearPiece(Square square, Piece piece) {

        if (isRegularBoard()) {
            jbtnArr[piece.getY()][piece.getX()].setIcon(null);
        } else {

            jbtn3DArr[square.getChessBoard().getBoardNo()][piece.getY()][piece.getX()].setIcon(null);
        }
    }

    /**
     * to check if regular board or 3d board
     * 
     * @return true if regular board ,false otherwise
     */
    public boolean isRegularBoard() {
        return jbtn3DArr == null;
    }

}
