package com.company;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StartGUI {
    private final String[] buttonsName = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0","#","Clear","Backspace", "Enter"};
    private final ImageIcon[] buttonsIcon = {
            new ImageIcon("H:\\Java\\Text_on_9_keys\\pics\\1.png"),
            new ImageIcon("H:\\Java\\Text_on_9_keys\\pics\\2.png"),
            new ImageIcon("H:\\Java\\Text_on_9_keys\\pics\\3.png"),
            new ImageIcon("H:\\Java\\Text_on_9_keys\\pics\\4.png"),
            new ImageIcon("H:\\Java\\Text_on_9_keys\\pics\\5.png"),
            new ImageIcon("H:\\Java\\Text_on_9_keys\\pics\\6.png"),
            new ImageIcon("H:\\Java\\Text_on_9_keys\\pics\\7.png"),
            new ImageIcon("H:\\Java\\Text_on_9_keys\\pics\\8.png"),
            new ImageIcon("H:\\Java\\Text_on_9_keys\\pics\\9.png"),
            new ImageIcon("H:\\Java\\Text_on_9_keys\\pics\\star.png"),
            new ImageIcon("H:\\Java\\Text_on_9_keys\\pics\\0.png"),
            new ImageIcon("H:\\Java\\Text_on_9_keys\\pics\\lattice.png"),
            new ImageIcon("H:\\Java\\Text_on_9_keys\\pics\\clear.png"),
            new ImageIcon("H:\\Java\\Text_on_9_keys\\pics\\enter.png"),
            new ImageIcon("H:\\Java\\Text_on_9_keys\\pics\\backspace.png")
    };
    private final String[] valuesOfButton0 = {"+","=","<",">","$","%","0"};
    private final String[] valuesOfButton1 = {".",",","-","?","!","@","(",")","/","1"};
    private final String[] valuesOfButton2 = {"а","б","в","г","2"};
    private final String[] valuesOfButton3 = {"д","е","ё","ж","з","3"};
    private final String[] valuesOfButton4 = {"и","й","к","л","4"};
    private final String[] valuesOfButton5 = {"м","н","о","п","5"};
    private final String[] valuesOfButton6 = {"р","с","т","у","6"};
    private final String[] valuesOfButton7 = {"ф","х","ц","ч","7"};
    private final String[] valuesOfButton8 = {"ш","щ","ъ","ы","8"};
    private final String[] valuesOfButton9 = {"ь","э","ю","я","9"};
    private final String[] valuesOfButtonStar = {"Abc", "abc", "ABC", "123"};
    private final Map<String,String[]> buttonsParams = new HashMap<>();

    private JTextComponent message;
    private JLabel typeMode;
    private int count = 0;
    private int countMode = 0;
    private String previousButtonName="";
    private long lastTime;

    public void loadMap(){
        buttonsParams.put("0",valuesOfButton0);
        buttonsParams.put("1",valuesOfButton1);
        buttonsParams.put("2",valuesOfButton2);
        buttonsParams.put("3",valuesOfButton3);
        buttonsParams.put("4",valuesOfButton4);
        buttonsParams.put("5",valuesOfButton5);
        buttonsParams.put("6",valuesOfButton6);
        buttonsParams.put("7",valuesOfButton7);
        buttonsParams.put("8",valuesOfButton8);
        buttonsParams.put("9",valuesOfButton9);
        buttonsParams.put("*",null);
        buttonsParams.put("#",null);
        buttonsParams.put("Clear", null);
        buttonsParams.put("Backspace", null);
        buttonsParams.put("Enter", null);
    }

    public static void main(String[] args) {
        StartGUI gui = new StartGUI();
        gui.loadMap();
        gui.createAndShowGUI();
    }
    private void createAndShowGUI(){

        JFrame frame = new JFrame("NOKLA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(279+8,356));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(287,219));
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setBackground(Color.BLACK);
        menuPanel.setVisible(true);

        JLabel mobileLabel = new JLabel("NOKLA");
        mobileLabel.setBackground(Color.ORANGE);
        menuPanel.add(mobileLabel, new GridBagConstraints(
                0, 0, 2, 1, 2,1,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(0,0,0,0),0,0));
        mobileLabel.setVisible(true);

        typeMode = new JLabel("Abc");
        menuPanel.add(typeMode, new GridBagConstraints(
                2, 0, 1, 1, 1,1,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(0,0,0,0),0,0));
        typeMode.setVisible(true);

        message = new JEditorPane();
        message.setPreferredSize(new Dimension(274, 100));
        menuPanel.add(message, new GridBagConstraints(
                0, 1, 3, 2, 3,2,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(0,0,0,0),0,0));
        message.setVisible(true);

        int dY = 1 + 2; // Значения gridheight у mobileLabel и message
        int columns_of_buttons = 3;
        int rows_of_buttons = (int) Math.ceil(buttonsName.length * 1.0/columns_of_buttons); //4
        int buttonsNameK = 0;
        JButton[][] buttons = new JButton[rows_of_buttons][columns_of_buttons];
        for (int i = 0; i < rows_of_buttons; i++){
            for(int j = 0; j < columns_of_buttons; j++){
                buttons[i][j] = new JButton(buttonsName[buttonsNameK]);
                buttons[i][j].setPreferredSize(new Dimension(90,40));
                if (buttonsParams.containsKey(buttons[i][j].getText())){
                    ActionListener b1 = new ButtonListener(buttons[i][j].getText(), buttonsParams.get(buttons[i][j].getText()));
                    buttons[i][j].addActionListener(b1);
                }
                buttons[i][j].setIcon(buttonsIcon[buttonsNameK]);
                menuPanel.add(buttons[i][j],
                        new GridBagConstraints(
                                j, i + dY, 1, 1, 1,1,
                                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                                new Insets(0,0,0,0),0,0));
                buttons[i][j].setVisible(true);
                buttonsNameK++;
            }
        }
        frame.setResizable(false);
        frame.validate();
        frame.add(menuPanel);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.pack();
        frame.setVisible(true);
    }
    private String currentMode = valuesOfButtonStar[countMode];
    class ButtonListener implements ActionListener {
        private final String BUTTON_NAME;
        private final String[] VALUES;

        public ButtonListener(String buttonName, String[] values) {
            BUTTON_NAME = buttonName.toLowerCase();
            VALUES = values;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            long startTime = System.currentTimeMillis();
            String resultText = message.getText();
            if (!previousButtonName.equals(BUTTON_NAME)) {
                count = 0;
                lastTime = 0;
            }
            if(VALUES != null) {
                if (count > VALUES.length - 1) {
                    count = 0;
                }
                if (startTime - lastTime > 750) {
                    count = 0;
                    if(previousButtonName.equals(BUTTON_NAME) && currentMode.equals(valuesOfButtonStar[0])){
                        currentMode = valuesOfButtonStar[1];
                        countMode = 1;
                        typeMode.setText(currentMode);
                    }
                    resultText += checkMode(VALUES[count], VALUES[VALUES.length-1]);
                } else {
                    if (startTime - lastTime >= 0) {
                        resultText = cutOnOneSymbol(resultText) + checkMode(VALUES[count], VALUES[VALUES.length-1]);
                    }
                }
                count++;
            }  else {
                switch (BUTTON_NAME){
                    case "*": {
                        if(countMode >= 3) {
                            countMode = 0;
                        } else {
                            countMode++;
                        }
                        currentMode = valuesOfButtonStar[countMode];
                        typeMode.setText(currentMode);
                        break;
                    }
                    case "#": {
                        resultText += " ";
                        break;
                    }
                    case "clear": {
                        resultText = "";
                        countMode = 0;
                        currentMode = valuesOfButtonStar[countMode];
                        typeMode.setText(currentMode);
                        break;
                    }
                    case "backspace": {
                        resultText = cutOnOneSymbol(resultText);
                        break;
                    }
                    case "enter": {
                        resultText +="\n";
                        countMode = 0;
                        currentMode = valuesOfButtonStar[countMode];
                        typeMode.setText(currentMode);
                        break;
                    }
                }
            }
            message.setText(resultText);
            lastTime = System.currentTimeMillis();
            previousButtonName = BUTTON_NAME;
        }

        private String cutOnOneSymbol(String text) {
            return Optional.ofNullable(text)
                    .filter(str -> str.length() != 0)
                    .map(str -> str.substring(0, str.length() - 1))
                    .orElse(text);
        }

        private String checkMode(String text, String number){
            String modifyText = text;
            switch (currentMode){
                case "Abc":{
                    if(!previousButtonName.equals("") && !previousButtonName.equals(BUTTON_NAME) && !"".equals(message.getText()) && !previousButtonName.equals("*")) {
                        countMode = 1;
                        currentMode = valuesOfButtonStar[countMode];
                        typeMode.setText(currentMode);
                        modifyText = text.toLowerCase();
                    }
                    else {
                        modifyText = text.toUpperCase();
                    }
                    break;
                }
                case "abc":{
                    modifyText = text.toLowerCase();
                    break;
                }
                case "ABC":{
                    modifyText = text.toUpperCase();
                    break;
                }
                case "123":{
                    modifyText = number;
                    break;
                }
            }
            return modifyText;
        }
    }
}