package ru.littlebigbro;

import javax.swing.text.JTextComponent;
import java.util.Optional;

import static ru.littlebigbro.TypeModeEnum.FIRST_UPPERCASE;

public class Utils {
    public static void performAction(ApplicationContext applicationContext, String buttonName) {
        JTextComponent message = applicationContext.getMessage();
        ActionContext actionContext = applicationContext.getActionContext(buttonName);
        int count = actionContext.getCount();
        long lastTime = actionContext.getLastTime();
        String[] values = applicationContext.getValues(buttonName);
        int countMode = actionContext.getCountMode();

        long startTime = System.currentTimeMillis();
        String previousButtonName = applicationContext.getPreviousButtonName();
        String resultText = message.getText();
        if (!previousButtonName.equals(buttonName)) {
            count = 0;
            lastTime = 0;
        }
        if (values != null) {
            if ("*".equals(buttonName)) {
                if (countMode >= 3) {
                    countMode = 0;
                } else {
                    countMode++;
                }
                String mode = values[countMode];
                applicationContext.setIsFirstLetter(FIRST_UPPERCASE.getTitle().equals(mode));
                applicationContext.setFirstAction(FIRST_UPPERCASE.getTitle().equals(mode));
                applicationContext.setTypeMode(TypeModeEnum.getName(mode).getTitle());
                actionContext.setCountMode(countMode);
                return;
            }

            if (count > values.length - 1) {
                count = 0;
            }
            boolean onlyNumberMode = TypeModeEnum.isOnlyNumberMode(applicationContext.getTypeMode());
            if (onlyNumberMode || (startTime - lastTime > 750 && !applicationContext.getFirstAction())) {
                count = 0;
                applicationContext.setIsFirstLetter(false);
                resultText += addText(applicationContext, values[count], values[values.length - 1]);
            } else {
                String cutText = applicationContext.getFirstAction() ? resultText : cutOnOneSymbol(resultText);
                resultText = cutText + addText(applicationContext, values[count], values[values.length - 1]);
            }
            count++;
        } else {
            switch (buttonName.toLowerCase()) {
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
        actionContext.setCount(count);
        message.setText(resultText);
        actionContext.setLastTime(System.currentTimeMillis());
        applicationContext.setPreviousButtonName(buttonName);
        if (applicationContext.getFirstAction()) {
            applicationContext.setFirstAction(false);
        }
    }

    private static String cutOnOneSymbol(String text) {
        return Optional.ofNullable(text)
                .filter(str -> str.length() != 0)
                .map(str -> str.substring(0, str.length() - 1))
                .orElse(text);
    }

    private static String addText(ApplicationContext applicationContext, String text, String number) {
        String modifyText;
        switch (TypeModeEnum.getName(applicationContext.getTypeMode())) {
            case FIRST_UPPERCASE: {
                if (!applicationContext.isFirstLetter()) {
                    modifyText = text.toLowerCase();
                } else {
                    modifyText = text.toUpperCase();
                }
                break;
            }
            case LOWERCASE: {
                modifyText = text.toLowerCase();
                break;
            }
            case UPPERCASE: {
                modifyText = text.toUpperCase();
                break;
            }
            case ONLY_NUMBERS: {
                modifyText = number;
                break;
            }
            default: {
                modifyText = text.toLowerCase();
            }
        }
        return modifyText;
    }
}