package com.company;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;

public class Gui {
    public static void run() {
        JFrame frame = new JFrame("NOKLA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(279 + 16, 368));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(287, 219));
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setBackground(Color.BLACK);
        menuPanel.setVisible(true);

        JLabel mobileLabel = new JLabel("NOKLA");
        mobileLabel.setForeground(Color.ORANGE);
        menuPanel.add(mobileLabel, new GridBagConstraints(
                0, 0, 2, 1, 2, 1,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(0, 0, 0, 0), 0, 0));
        mobileLabel.setVisible(true);

        JLabel typeMode = new JLabel("Abc");
        typeMode.setForeground(Color.GREEN);
        menuPanel.add(typeMode, new GridBagConstraints(
                2, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(0, 0, 0, 0), 0, 0));
        typeMode.setVisible(true);

        JTextComponent message = new JEditorPane();
        message.setPreferredSize(new Dimension(274, 100));
        menuPanel.add(message, new GridBagConstraints(
                0, 1, 3, 2, 3, 2,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(0, 0, 0, 0), 0, 0));
        message.setVisible(true);
        message.setEditable(false);

        int dY = 1 + 2; // Значения gridheight у mobileLabel и message

        MButton[][] buttons = ButtonsSetups.getButtonsArray();
        State state = new State();
        state.setFirst(true);
        for (int i = 0; i < ButtonsSetups.arrayRows; i++) {
            for (int j = 0; j < ButtonsSetups.arrayColumns; j++) {
                MButton mButton = buttons[i][j];
                JButton b = new JButton(mButton.getName());
                b.setPreferredSize(new Dimension(90, 40));
                ActionListener b1 = new ButtonListener(state, message, typeMode, mButton.getName(), mButton.getValues());
                b.addActionListener(b1);
                b.setIcon(mButton.getIcon());
                menuPanel.add(b,
                        new GridBagConstraints(
                                j, i + dY, 1, 1, 1, 1,
                                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                                new Insets(0, 0, 0, 0), 0, 0));
                b.setVisible(true);
            }
        }
        frame.setResizable(true);
        frame.validate();
        frame.add(menuPanel);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.pack();
        frame.setVisible(true);
    }
}