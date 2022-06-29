package pl.programowanie;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactoryPanel extends JPanel {

    int time = (int)(Math.random()*2900+100);

    public FactoryPanel(Storage storage){

        Factory factory = new Factory(storage);
        setPreferredSize(new Dimension(150,150));

        JLabel number = new JLabel("Factory " + factory.getNumber());
        number.setFont(new Font("Arial", 1, 22));
        add(number);

        JLabel size = new JLabel();
        size.setFont(new Font("Arial", 0, 17));
        new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted())
                        size.setText("Balloons " + factory.getSum());
                }
        ).start();
        add(size);

        final JButton delate = new JButton();
        delate.setPreferredSize(new Dimension(120, 50));
        delate.setText("Delete factory");
        delate.setFont(new Font("Arial", 1, 15));
        delate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //delete
            }
        });
        add(delate);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 100, 3000, time);
        slider.addChangeListener(
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        time = slider.getValue();
                    }
                }
        );
        add(slider);

        setBorder(BorderFactory.createLineBorder(Color.black));
    }
}