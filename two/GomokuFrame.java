 /* Subclass of JFrame that holds the main method of Gomoku program
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GomokuFrame extends JFrame  {
    public static void main(String args[]) throws Exception {
        //GoBoard gb = GoBoard.fromFile("C:/Users/admin/IdeaProjects/Homework 8/src/two/stones.txt");
        GomokuAI ai = new GomokuAI();

        GomokuBoard gb = new GomokuBoard(ai);
        JFrame frame = new JFrame("Gomoku Board");
        JPanel p = new JPanel();
        JPanel p2 = new JPanel();
        //frame.add(gb);
        frame.setSize(720, 810);
        frame.setLocation(300, 10);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JButton bt = new JButton("New Game");
        p2.setLayout(new GridLayout());
        bt.setSize(720, 40);

        //p.setSize();
        p.setLayout(new GridLayout());
        JLabel blacks = new JLabel();
        JLabel whites = new JLabel();
        blacks.setSize(360, 80);
        whites.setSize(360, 80);
        blacks.setHorizontalAlignment(SwingConstants.CENTER);
        whites.setHorizontalAlignment(SwingConstants.CENTER);

        blacks.setForeground(Color.black);
        whites.setForeground(Color.white);
        blacks.setFont(new Font("SansSerif", Font.BOLD, 32));
        whites.setFont(new Font("SansSerif", Font.BOLD, 32));
        blacks.setText("Black: " + gb.getBlackScore());
        whites.setText("White: " + gb.getWhiteScore());

        p.setBackground(Color.decode("#ffd294"));

        p2.add(bt);
        p.add(blacks);
        p.add(whites);

        frame.getContentPane().add(p, BorderLayout.NORTH);
        frame.getContentPane().add(gb, BorderLayout.CENTER);
        frame.getContentPane().add(p2, BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.repaint();

        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gb.resetGame();
                frame.repaint();
            }
        });


        gb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                blacks.setText("Black: " + gb.getBlackScore());
                whites.setText("White: " + gb.getWhiteScore());
            }
        });

        frame.setVisible(true);
        frame.repaint();

    }
}
