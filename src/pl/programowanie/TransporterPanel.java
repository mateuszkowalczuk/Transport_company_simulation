package pl.programowanie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransporterPanel extends JPanel {

    public TransporterPanel(Storage storage){
        Transporter transporter = new Transporter(storage);
        setPreferredSize(new Dimension(150,150));

        JLabel number = new JLabel("Transporter " + transporter.getNumber());
        number.setFont(new Font("Arial", 1, 22));
        add(number);

        JLabel status = new JLabel();
        status.setFont(new Font("Arial", 0, 17));
        new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted())
                        status.setText("" + transporter);
                }
        ).start();
        add(status);

        final JButton run = new JButton();
        run.setPreferredSize(new Dimension(65, 50));
        run.setText("On");
        run.setFont(new Font("Arial", 1, 15));
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //On
            }
        });
        add(run);

        final JButton stop = new JButton();
        stop.setPreferredSize(new Dimension(65, 50));
        stop.setText("Off");
        stop.setFont(new Font("Arial", 1, 15));
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Off
            }
        });
        add(stop);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}