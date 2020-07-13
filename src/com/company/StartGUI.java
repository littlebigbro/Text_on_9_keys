package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
Необходимо доработать звездочку
Добавить кнопку которая удаляет только последний символ.
Нашел 2 баги:
1) При нажатии кнопки n раз, следующее нажатие через большой промежуток времени добавит символ не n[0], а n+1
2) При нажатии нескольких кнопок очень быстро они перезатирают предыдущее значение
*/
public class StartGUI {
    private final String[] buttonsName = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0","#"};
    private final JButton[] buttons = new JButton[buttonsName.length];
    private JLabel messageLabel;
    private int count = 1;
    private String previousButtonText="";
    private long endTime;
    private String currentMsg;

    public static void main(String[] args) {
        StartGUI gui = new StartGUI();
        gui.createAndShowGUI();
    }
    private void createAndShowGUI(){
        JFrame frame = new JFrame("NOKLA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(279+8,300));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));


        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(287,120));
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setBackground(Color.pink);
        menuPanel.setVisible(true);

        JLabel mobileLabel = new JLabel("NOKLA");
        menuPanel.add(mobileLabel, new GridBagConstraints(
                0, 0, 3, 1, 3,1,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(0,0,0,0),0,0));
        mobileLabel.setVisible(true);

        messageLabel = new JLabel("!");
        menuPanel.add(messageLabel, new GridBagConstraints(
                0, 1, 3, 2, 3,2,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(0,0,0,0),0,0));
        messageLabel.setVisible(true);

        int dY = 1 + 2; // Значения gridheight у mobileLabel и messageLabel
        int columns_of_buttons = 3;
        int rows_of_buttons = buttonsName.length/columns_of_buttons; //4
        int buttonsNameK = 0;
        for (int i = 0; i < rows_of_buttons; i++){
            for(int j = 0; j < columns_of_buttons; j++){
                JButton button = new JButton(buttonsName[buttonsNameK]);
                button.setPreferredSize(new Dimension(90,40));
                button.addActionListener(new ButtonListener(buttonsName[buttonsNameK]));
                menuPanel.add(button,
                        new GridBagConstraints(
                                j, i + dY, 1, 1, 1,1,
                                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                                new Insets(0,0,0,0),0,0));
                button.setVisible(true);
                buttonsNameK++;
            }
        }
        JButton clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(90,40));
        clearButton.addActionListener(new ButtonListener(clearButton.getText().toLowerCase()));
        menuPanel.add(clearButton,
                new GridBagConstraints(
                        0, 8, 3, 1, 3,1,
                        GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                        new Insets(0,0,0,0),0,0));
        clearButton.setVisible(true);

        frame.add(menuPanel);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.pack();
        frame.setVisible(true);
    }

    class ButtonListener implements ActionListener {
        private String buttonText;
        long startTime = System.currentTimeMillis();

        public ButtonListener(String buttonText){
            this.buttonText = buttonText;
            currentMsg = messageLabel.getText();
        }

        private void counterCheck(int arrayLength){
            if (arrayLength < count || !previousButtonText.equals(buttonText)){
                count = 1;
            }
        }

        private String timeCheck(long duration, String symbol){
            if (duration >= 500){
                currentMsg = messageLabel.getText();
                count = 0;
            } else {
                if (duration >= 0){
                    startTime = System.currentTimeMillis();
                }
            }
            count++;
            return currentMsg + symbol;
        }

        public void actionPerformed(ActionEvent e) {
            startTime = System.currentTimeMillis();
            long duration = 0;
            String symbol = "";
            if (endTime != 0)
                {duration = startTime - endTime;}
            switch (buttonText) {
                case "1": {
                    String[] digit_1_values = {".",",","-","?","!","@","(",")","/","1"};
                    counterCheck(digit_1_values.length);
                    symbol = digit_1_values[count-1];
                    break;
                }
                case "2": {
                    String[] digit_2_values = {"а","б","в","г","2"};
                    counterCheck(digit_2_values.length);
                    symbol = digit_2_values[count-1];
                    break;
                }
                case "3": {
                    String[] digit_3_values = {"д","е","ё","ж","з","3"};
                    counterCheck(digit_3_values.length);
                    symbol = digit_3_values[count-1];
                    break;
                }
                case "4": {
                    String[] digit_4_values = {"и","й","к","л","4"};
                    counterCheck(digit_4_values.length);
                    symbol = digit_4_values[count-1];
                    break;
                }
                case "5": {
                    String[] digit_5_values = {"м","н","о","п","5"};
                    counterCheck(digit_5_values.length);
                    symbol = digit_5_values[count-1];
                    break;
                }
                case "6": {
                    String[] digit_6_values = {"р","с","т","у","6"};
                    counterCheck(digit_6_values.length);
                    symbol = digit_6_values[count-1];
                    break;
                }
                case "7": {
                    String[] digit_7_values = {"ф","х","ц","ч","7"};
                    counterCheck(digit_7_values.length);
                    symbol = digit_7_values[count-1];
                    break;
                }
                case "8": {
                    String[] digit_8_values = {"ш","щ","Ъ","ы","8"};
                    counterCheck(digit_8_values.length);
                    symbol = digit_8_values[count-1];
                    break;
                }
                case "9": {
                    String[] digit_9_values = {"ь","э","ю","я","9"};
                    counterCheck(digit_9_values.length);
                    symbol = digit_9_values[count-1];
                    break;
                }
                case "0": {
                    String[] digit_0_values = {"+","=","<",">","$","%","0"};
                    counterCheck(digit_0_values.length);
                    symbol = digit_0_values[count-1];
                    break;
                }
                case "*": {
                    /*
                    Первая заглавная остальные строчные включить UpperCase для первого нажатия
                    Все заглавные включить UpperCase
                    Все строчные отключить UpperCase
                    Все цифры просто брать последний символ массива.
                    */
                    messageLabel.setText(messageLabel.getText()+"+");
                    break;
                }
                case "#": {
                    messageLabel.setText(messageLabel.getText()+" ");
                    break;
                }

                case "clear": {
                    messageLabel.setText("");
                }
            }
            previousButtonText = this.buttonText;
            String t = timeCheck(duration, symbol);
            messageLabel.setText(t);
            endTime = System.currentTimeMillis();
        }
    }
}