package pl.programowanie;

import javax.swing.*;

public class S24487P02 {

    public static void main(String[] args)  {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame();
            }
        });

    }
}