package ru.littlebigbro;

import ru.littlebigbro.Listeners.ButtonListener;
import ru.littlebigbro.Listeners.KeysListener;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;

public class Gui {
    public static void create(ApplicationContext applicationContext) {
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

        JLabel typeModeLabel = new JLabel();
        typeModeLabel.setForeground(Color.GREEN);
        menuPanel.add(typeModeLabel, new GridBagConstraints(
                2, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(0, 0, 0, 0), 0, 0));
        typeModeLabel.setVisible(true);
        applicationContext.setTypeModeLabel(typeModeLabel);

        JTextComponent message = new JEditorPane();
        message.setPreferredSize(new Dimension(274, 100));
        message.addKeyListener(new KeysListener(applicationContext));
        applicationContext.setMessage(message);
        menuPanel.add(message, new GridBagConstraints(
                0, 1, 3, 2, 3, 2,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(0, 0, 0, 0), 0, 0));
        message.setVisible(true);
        message.setEditable(false);
        message.setFocusable(true);
        int dY = 1 + 2; // Значения gridheight у mobileLabel и message

        MButton[][] buttons = applicationContext.getButtonsArray();
        for (int i = 0; i < applicationContext.getButtonsArrayRows(); i++) {
            for (int j = 0; j < applicationContext.getButtonsArrayColumns(); j++) {
                MButton mButton = buttons[i][j];
                JButton b = new JButton(mButton.getName());
                b.setPreferredSize(new Dimension(90, 40));
                ActionListener buttonListener = new ButtonListener(applicationContext, mButton.getName());
                b.addActionListener(buttonListener);
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
        frame.pack();
        frame.setVisible(true);
    }
}