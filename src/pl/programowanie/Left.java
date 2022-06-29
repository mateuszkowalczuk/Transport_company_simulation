package pl.programowanie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Left extends JPanel {

    public Left(Storage storage){
        setLayout(new GridLayout(0, 1));
        setBackground(new Color(85,107,47));

        final JButton button = new JButton();
        button.setPreferredSize(new Dimension(150, 150));
        button.setText("Add factory");
        button.setFont(new Font("Arial", 1, 18));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(new FactoryPanel(storage));
            }
        });
        add(button);
    }
}