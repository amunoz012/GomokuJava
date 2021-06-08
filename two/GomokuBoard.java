 /* continuation of GoBoard done in the previous homework
  *
  *
  *
  *
  *
  * @author Antonio Munoz
  * @version HW 8, #2
  * @bugs
  */


package two;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Scanner;

public class GomokuBoard extends JComponent {

    private Stone stones[][];
    private Image img;
    private GomokuAI ai;
    private int blackScore;
    private int whiteScore;
    private boolean gameOver;

    public GomokuBoard(GomokuAI ai){
        this.ai = ai;
        blackScore = whiteScore = 0;
        gameOver = false;
        Dimension dim  = new Dimension(720, 720);
        this.setPreferredSize(dim);
        stones = new Stone[19][19];
        for ( int i =0 ; i<19; i++){
            for (int j = 0; j<19; j++){
                stones[i][j] = Stone.EMPTY;
            }
        }
        ImageIcon icon = new ImageIcon("C:/Users/admin/IdeaProjects/Homework 8/src/two/bamboo.jpg");
        img = icon.getImage();

        this.addMouseListener(new PlayHandler());
    }

    public void addStone(int i, int j, Color c){
        if ( i>=0 && i<=18 && j>=0 && j<=18){
            if (c == Color.black)
                stones[i][j] = Stone.BLACK;
            else
                stones[i][j] = Stone.WHITE;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(img, 0,0,this);
        setOpaque(false);
        //super.paint(g);
        setOpaque(true);

        for ( int i=0; i<19; i++){
            for (int j=0; j<19; j++){

                if( i<18 && j < 18) {
                    g.setColor(Color.black);
                    g.drawRect(45 + i * 35, 45 + j * 35, 35, 35);
                }
                if( stones[i][j] == Stone.BLACK) {
                    g.setPaintMode();
                    g.setColor(Color.BLACK);
                    g.fillOval(30 + i * 35, 30 + j * 35, 32, 32);
                }
                if( stones[i][j] == Stone.WHITE) {
                    g.setPaintMode();
                    g.setColor(Color.WHITE);
                    g.fillOval(30 + i * 35, 30 + j * 35, 32, 32);
                }
            }
        }

    }

    public static GomokuBoard fromFile(String f) throws Exception{
        File file = new File(f);
        GomokuAI ai = null;
        GomokuBoard gb = new GomokuBoard(ai);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {

            String[] inp = sc.nextLine().split(" ");
            if (inp[0].compareTo("B") == 0) {
                int i = inp[1].charAt(0) - 65;
                if (i >= 'I') {
                    i -= 1;
                }
                int j = Integer.parseInt(inp[2]) - 1;
                gb.addStone(i, j, Color.black);
                //System.out.println(i+" "+j);
            } else {
                int i = inp[1].charAt(0) - 65;
                if (i >= 'I') {
                    i -= 1;
                }
                int j = Integer.parseInt(inp[2]) - 1;
                gb.addStone(i, j, Color.white);
                //System.out.println(i+" "+j);

            }
        }

        return gb;
    }

    public boolean playBlack(int i, int j){
        //System.out.println(stones[i][j].getColor().toString());
        System.out.println(i + "," + j);
        if ( i < 19 && i >=0 && j >= 0 && j <19 && stones[i][j].getColor() == null){
            addStone(i,j,Color.black);

            super.repaint();
            return true;
        }
        else{
            return false;
        }
    }
    public boolean playWhite(){
        int cords[] = new int[2];

        cords = ai.getMove(stones);
        int i = cords[0];
        int j = cords[1];

        if ( i < 19 && i >=0 && j >= 0 && j <19 && stones[i][j].getColor() == null){
            addStone(i,j,Color.white);

            super.repaint();
            return true;
        }
        else{
            return false;
        }
    }

    public void resetGame(){
        for ( int i =0 ; i<19; i++){
            for (int j = 0; j<19; j++){
                stones[i][j] = Stone.EMPTY;
            }
        }
        gameOver = false;
        super.repaint();
    }

    public int getBlackScore(){
        return blackScore;
    }

    public int getWhiteScore() {
        return whiteScore;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    private class PlayHandler extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if( gameOver ){
                return;
            }

            int x = (int) Math.floor( (e.getX() - 30.0) / 35.0 );
            int y = (int) Math.floor( (e.getY() - 30.0) / 35.0 );

            if (!playBlack(x,y)){
                return;
            }
            else{
                if ( ai.checkWinner(stones) == Stone.BLACK){
                    gameOver = true;
                    blackScore++;
                    return;
                }
            }

            if( !gameOver ){
                if ( playWhite() ){
                    if ( ai.checkWinner(stones) == Stone.WHITE){
                        gameOver = true;
                        whiteScore++;
                        return;
                    }
                }
            }
        }
    }
}
