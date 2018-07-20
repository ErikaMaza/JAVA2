package ru.geekbrains.dz_lesson4.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SendPanel extends JPanel{

    private JTextField textField;
    private JTextArea textArea;
    private String br;
    private Date date;
    private final SimpleDateFormat dateFormat;

    SendPanel(JTextArea textArea) {
        this.textArea = textArea;

        textField = new JTextField() {
            @Override
            public void addNotify() {
                super.addNotify();
                requestFocus();
            }
        };

        br = "";
        dateFormat = new SimpleDateFormat("HH:mm");

        setup();
    }

    private void setup() {
        setLayout(new BorderLayout());
        JButton btn = new JButton("Send");

        btn.addActionListener(new SendBtnListener());
        textField.addActionListener(new SendBtnListener());

        add(textField, BorderLayout.CENTER);
        add(btn, BorderLayout.EAST);
    }

    private String getTime() {
        date = new Date();
        return dateFormat.format(date);
    }

    private void append() {
        String text = textField.getText();

        if (!text.isEmpty()) {
            textArea.setText(String.format("%s%s[%s] %s", textArea.getText(), br, getTime(), text));
            textField.setText("");
            br = "\n";
        }
    }

    private class SendBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() instanceof JButton) {
                append();
            }

            if (e.getSource() instanceof JTextField) {
                append();
            }
        }
    }
}
