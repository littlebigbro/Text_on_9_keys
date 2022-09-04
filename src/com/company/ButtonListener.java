package com.company;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class ButtonListener implements ActionListener {
    private final String BUTTON_NAME;
    private final JTextComponent message;
    private final String[] VALUES;
    private final State state;
    private long lastTime = 0;
    private int count = 0;
    private int countMode = 0;
    private final JLabel typeMode;

    public ButtonListener(State state, JTextComponent message, JLabel typeMode, String buttonName, String[] values) {
        BUTTON_NAME = buttonName.toLowerCase();
        VALUES = values;
        this.message = message;
        this.typeMode = typeMode;
        this.state = state;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        long startTime = System.currentTimeMillis();
        String previousButtonName = state.getPreviousButtonName();
        String resultText = message.getText();
        if (!previousButtonName.equals(BUTTON_NAME)) {
            count = 0;
            lastTime = 0;
        }
        if (VALUES != null) {
            if ("*".equals(BUTTON_NAME)) {
                if (countMode >= 3) {
                    countMode = 0;
                } else {
                    countMode++;
                }
                String mode = VALUES[countMode];
                state.setFirst("Abc".equals(mode));
                typeMode.setText(mode);
                return;
            }

            if (count > VALUES.length - 1) {
                count = 0;
            }

            if (startTime - lastTime > 750) {
                count = 0;
                resultText += checkMode(VALUES[count], VALUES[VALUES.length - 1]);
            } else {
                resultText = cutOnOneSymbol(resultText) + checkMode(VALUES[count], VALUES[VALUES.length - 1]);
            }

            count++;
        } else {
            switch (BUTTON_NAME) {
                case "#": {
                    resultText += " ";
                    break;
                }
                case "clear": {
                    resultText = "";
                    break;
                }
                case "backspace": {
                    resultText = cutOnOneSymbol(resultText);
                    break;
                }
                case "enter": {
                    resultText += "\n";
                    break;
                }
            }
        }
        message.setText(resultText);
        lastTime = System.currentTimeMillis();
        state.setPreviousButtonName(BUTTON_NAME);
    }

    private String cutOnOneSymbol(String text) {
        return Optional.ofNullable(text)
                .filter(str -> str.length() != 0)
                .map(str -> str.substring(0, str.length() - 1))
                .orElse(text);
    }

    private String checkMode(String text, String number) {
        String modifyText = text;
        switch (typeMode.getText()) {
            case "Abc": {
                if (!state.getFirst()) {
                    modifyText = text.toLowerCase();
                } else {
                    modifyText = text.toUpperCase();
                    state.setFirst(false);
                }
                break;
            }
            case "abc": {
                modifyText = text.toLowerCase();
                break;
            }
            case "ABC": {
                modifyText = text.toUpperCase();
                break;
            }
            case "123": {
                modifyText = number;
                break;
            }
        }
        return modifyText;
    }
}