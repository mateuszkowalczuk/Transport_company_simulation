package pl.programowanie;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

class Center extends JPanel {

    public Center(Storage storage) {
        setBackground(new Color(85,107,47));

        JPanel draw = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                if (storage.size() != 0) {
                    Queue<Baloon> baloons = new LinkedList<>();
                    storage.forEach(baloons);

                    if (storage.size() == 90) storage.clear();
                    else if (storage.size() != 0) {
                        for (int i = 0; i < baloons.size(); i += 0.5) {
                            Baloon baloon = baloons.peek();
                            BaloonColor color = baloon.color;
                            int x = baloon.x;
                            int y = baloon.y;

                            g2d.setColor(new Color(color.getR(), color.getG(), color.getB()));
                            g2d.fillOval(x, y, 50, 50);
                            baloons.remove();
                        }
                    }

                }
                repaint();
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(500, 400);
            }
        };
        add(draw);

        JPanel size = new JPanel();
        size.setBackground(new Color(85,107,47));
        size.setPreferredSize(new Dimension(500,80));
        JLabel text = new JLabel();
        text.setFont(new Font("Arial", 1, 20));

        new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) text.setText("Size " + storage.size());
                }
        ).start();

        add(size.add(text));
    }
}