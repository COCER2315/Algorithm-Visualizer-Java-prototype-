import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Actions.*;

public class Main implements ActionListener {
    public static void main(String[] args) {
        // the main screen
        // two buttons in the center, one called "Sorting Algorithms", the other "Graph Algorithms"
        JFrame frm = new JFrame("Algorithm Visualizer");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(1000, 600);
        JButton b1 = new JButton("Sort Algorithms");
        JButton b2 = new JButton("Graph Algorithms");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        JPanel panel = new JPanel();
        b1.setPreferredSize(new Dimension(300, 50));
        b1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frm.getContentPane().removeAll();
                        Actions Act = new Actions();
                        frm.add(Act.sorts());
                        frm.revalidate();
                    }
                }
        );
        b2.setPreferredSize(new Dimension(300, 50));
        b2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frm.getContentPane().removeAll();
                        Actions Act = new Actions();
                        frm.add(Act.graphs());
                        frm.revalidate();
                    }
                }
        );
        panel.add(b1);
        panel.add(b2);
        frm.getContentPane().add(BorderLayout.CENTER, panel);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // If I don't include this Java throws an error, but the inner classes above makes all the stuff happen
        // This issue doesn't happen in the other files, no idea why...
    }
}