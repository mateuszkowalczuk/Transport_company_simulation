package pl.programowanie;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    Storage storage = new Storage();

    public MyFrame() {
        setTitle("Transport company");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,480);
        setVisible(true);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JScrollPane leftScroll = new JScrollPane(new Left(storage),
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        leftScroll.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add( leftScroll, BorderLayout.LINE_START );

        add( new JScrollPane( new Right(storage),
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER ), BorderLayout.LINE_END );

        add( new Center(storage), BorderLayout.CENTER );
    }
}