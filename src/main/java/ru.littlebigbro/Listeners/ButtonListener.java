package ru.littlebigbro.Listeners;

import ru.littlebigbro.ApplicationContext;
import ru.littlebigbro.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final ApplicationContext applicationContext;
    private final String buttonName;

    public ButtonListener(ApplicationContext applicationContext, String buttonName) {
        this.applicationContext = applicationContext;
        this.buttonName = buttonName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Utils.performAction(applicationContext, buttonName);
    }
}