package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGUI {
    public static void main(String[] args) {
        StartGUI gui = new StartGUI();
        gui.createAndShowGUI();
    }
    private void createAndShowGUI(){
        JFrame frame = new JFrame("Nokla");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(316,450));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setFocusable(true);
        frame.pack();

        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(200,200));
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setBackground(Color.BLUE);
        menuPanel.setVisible(true);

        JLabel mobileLabel = new JLabel("NOKLA");
        menuPanel.add(mobileLabel, new GridBagConstraints(0, 0, 1, 1, 3,1, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(0,0,0,0),0,0));
        mobileLabel.setVisible(true);

        JLabel messageLabel = new JLabel("TEST!");
        menuPanel.add(messageLabel, new GridBagConstraints(0, 1, 1, 1, 3,2, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(0,0,0,0),0,0));
        messageLabel.setVisible(true);

        frame.add(menuPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }



}

/*
 Nokla
 JLabel
 JLabel
 - ^ -
 \ | /
 1 2 3
 4 5 6
 7 8 9
 * 0 #
*/














