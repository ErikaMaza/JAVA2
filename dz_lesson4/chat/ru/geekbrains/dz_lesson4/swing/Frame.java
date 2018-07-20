package ru.geekbrains.dz_lesson4.swing;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Frame() {
        setTitle("Chat");
        ImageIcon icon = new ImageIcon("src/img/chat.png");
        setIconImage(icon.getImage());
        setSize(new Dimension(400, 400));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        TextPanel bigTextPanel = new TextPanel();
        SendPanel sendPanel = new SendPanel(bigTextPanel.getTextArea());

        add(bigTextPanel, BorderLayout.CENTER);
        add(sendPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
