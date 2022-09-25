package ru.littlebigbro.Listeners;

import ru.littlebigbro.ApplicationContext;
import ru.littlebigbro.MButton;
import ru.littlebigbro.Utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

public class KeysListener implements KeyListener {
    private ApplicationContext applicationContext;

    public KeysListener(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        String key = String.valueOf(e.getKeyChar());
        if (" ".equalsIgnoreCase(key)) {
            key = "#";
        }
        if ("c".equalsIgnoreCase(key)) {
            key = "Clear";
        }
        if ("\b".equalsIgnoreCase(key)) {
            key = "Backspace";
        }
        if ("\n".equalsIgnoreCase(key)) {
            key = "Enter";
        }

        if ("s".equalsIgnoreCase(key)) {
            key = "*";
        }
        Map<String, MButton> buttonsMap = applicationContext.getButtonsMap();
        if (!buttonsMap.containsKey(key)) {
            return;
        }
        Utils.performAction(applicationContext, key);
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
