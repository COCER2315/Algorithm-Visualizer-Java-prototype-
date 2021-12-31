package Actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.*;
import Graph2D.*;

public class Actions{
    public Actions() {
    }
    //save this font to clean up code
    Font font = new Font("Times New Roman", Font.PLAIN, 20);
    // what happens after clicking sort algorithms
    public JPanel sorts(){
        JPanel panel = new JPanel();
        JButton b0 = new JButton("back");
        JButton b1 = new JButton("bubble sort");
        JButton b2 = new JButton("selection sort");
        JButton b3 = new JButton("quick sort");
        JButton b4 = new JButton("merge sort");
        JButton b5 = new JButton("insertion sort");
        b0.setFont(font);
        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);
        b4.setFont(font);
        b5.setFont(font);
        b1.setPreferredSize(new Dimension(150, 30));
        b2.setPreferredSize(new Dimension(150, 30));
        b3.setPreferredSize(new Dimension(150, 30));
        b4.setPreferredSize(new Dimension(150, 30));
        b5.setPreferredSize(new Dimension(150, 30));
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actions a = new Actions();
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                topFrame.getContentPane().removeAll();
                topFrame.add(a.mainScreen());
                topFrame.revalidate();
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actions a = new Actions();
                a.bubbleSort();
                };
            });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actions a = new Actions();
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actions a = new Actions();
                ArrayList<Integer> input = randInput();
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actions a = new Actions();
                ArrayList<Integer> input = randInput();
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actions a = new Actions();
                ArrayList<Integer> input = randInput();
            }
        });
        panel.add(b0);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        return panel;
    }

    // what happens after clicking graph algorithms
    public JPanel graphs(){
        JPanel panel = new JPanel();
        JButton b0 = new JButton("back");
        JButton b1 = new JButton("Prim's Algorithm");
        JButton b2 = new JButton("Kruskal's Algorithm");
        JButton b3 = new JButton("Dijkstra's Algorithm");
        b0.setFont(font);
        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actions a = new Actions();
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                topFrame.getContentPane().removeAll();
                topFrame.add(a.mainScreen());
                topFrame.revalidate();
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actions a = new Actions();
                a.getres(panel, "src/prim.gif"); // can't get this to work even though it should've
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actions a = new Actions();
                a.getres(panel, "to be added later");
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actions a = new Actions();
                a.getres(panel, "to be added later");
            }
        });
        panel.add(b0);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        return panel;
    }

    // go back to main screen
    public JPanel mainScreen(){
        JButton b1 = new JButton("Sorting Algorithms");
        JButton b2 = new JButton("Graph Algorithms");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        JPanel panel = new JPanel();
        b1.setPreferredSize(new Dimension(300, 50));
        b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                        topFrame.getContentPane().removeAll();
                        Actions Act = new Actions();
                        topFrame.add(Act.sorts());
                        topFrame.revalidate();
                    }
                }
        );
        b2.setPreferredSize(new Dimension(300, 50));
        b2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                        topFrame.getContentPane().removeAll();
                        Actions Act = new Actions();
                        topFrame.add(Act.graphs());
                        topFrame.revalidate();
                    }
                }
        );
        panel.add(b1);
        panel.add(b2);
        return panel;
    }

    //now for the actual algorithms...
    //graph ones first
    public void getres(JPanel panel, String name) {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
        boolean ok = true;
        Actions action = new Actions();
        try{
            URL url = this.getClass().getResource(name);
            Icon icon1 = new ImageIcon(url);
        }
        catch(Exception e){
            ok = false;
            JFrame frame = new JFrame("Error");
            JLabel label = new JLabel("<html>Something went wrong!<br/>" + e + "</html>");
            label.setFont(font);
            frame.getContentPane().add(label);
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // note for future reference : can't add this line or program
            // will terminate when an error occurs
            frame.setSize(300,120);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
        if (ok){
            URL url = this.getClass().getResource(name);
            Icon icon1 = new ImageIcon(url);
            JLabel lbl = new JLabel(icon1);
            JButton bt = new JButton("back");
            bt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    topFrame.getContentPane().removeAll();
                    topFrame.add(action.graphs());
                    topFrame.revalidate();
                }
            });
            topFrame.getContentPane().removeAll();
            topFrame.add(lbl);
            topFrame.add(bt);
            topFrame.revalidate();
        }
        else {
            topFrame.getContentPane().removeAll();
            topFrame.add(action.graphs());
            topFrame.revalidate();
        }
    }
    // helper method to generate an ArrayList of random Integers as input to various sorts below
    public static ArrayList<Integer> randInput(){
        Random rand = new Random();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        while (map.size() != 10){
            Integer i = rand.nextInt(100);
            String str =  Integer.toString(i);
            map.put(str,i);
        }
        ArrayList list = new ArrayList<>();
        for (Integer i : map.values()){
            list.add(i);
        }
        return list;
    }
    // now for the actual sorts...
    public void bubbleSort(){
        JFrame frm = new JFrame("Bubble Sort");
        JPanel bubsrt = new JPanel();
        ArrayList<Integer> input = randInput();

        frm.add(bubsrt);
        System.out.println(input);
        frm.setSize(800,400);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }
}

