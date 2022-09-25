package ru.littlebigbro;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private static final String ZERO = "0";
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String FIVE = "5";
    private static final String SIX = "6";
    private static final String SEVEN = "7";
    private static final String EIGHT = "8";
    private static final String NINE = "9";

    private final int buttonsArrayRows = 5;
    private final int buttonsArrayColumns = 3;
    private MButton[][] buttonsArray;
    private Map<String, MButton> buttonsMap;
    private String previousButtonName = "";
    private JLabel typeModeLabel;
    private String typeMode = TypeModeEnum.FIRST_UPPERCASE.getTitle();
    private Boolean isFirstLetter = true;
    private Boolean isFirstAction = true;
    private JTextComponent message;

    public ApplicationContext() {
        createButtonsArray();
        creeateButtonsMap();
    }

    private void createButtonsArray() {
        buttonsArray = new MButton[buttonsArrayRows][buttonsArrayColumns];
        buttonsArray[0][0] = new MButton(ONE, new String[]{".", ",", "-", "?", "!", "@", "(", ")", "/", ONE}, new ImageIcon("pics\\1.png"));
        buttonsArray[0][1] = new MButton(TWO, new String[]{"а", "б", "в", "г", TWO}, new ImageIcon("pics\\2.png"));
        buttonsArray[0][2] = new MButton(THREE, new String[]{"д", "е", "ё", "ж", "з", THREE}, new ImageIcon("pics\\3.png"));
        buttonsArray[1][0] = new MButton(FOUR, new String[]{"и", "й", "к", "л", FOUR}, new ImageIcon("pics\\4.png"));
        buttonsArray[1][1] = new MButton(FIVE, new String[]{"м", "н", "о", "п", FIVE}, new ImageIcon("pics\\5.png"));
        buttonsArray[1][2] = new MButton(SIX, new String[]{"р", "с", "т", "у", SIX}, new ImageIcon("pics\\6.png"));
        buttonsArray[2][0] = new MButton(SEVEN, new String[]{"ф", "х", "ц", "ч", SEVEN}, new ImageIcon("pics\\7.png"));
        buttonsArray[2][1] = new MButton(EIGHT, new String[]{"ш", "щ", "ъ", "ы", EIGHT}, new ImageIcon("pics\\8.png"));
        buttonsArray[2][2] = new MButton(NINE, new String[]{"ь", "э", "ю", "я", NINE}, new ImageIcon("pics\\9.png"));
        buttonsArray[3][0] = new MButton("*", new String[]{"Abc", "abc", "ABC", "123"}, new ImageIcon("pics\\star.png"));
        buttonsArray[3][1] = new MButton(ZERO, new String[]{"+", "=", "<", ">", "$", "%", ZERO}, new ImageIcon("pics\\0.png"));
        buttonsArray[3][2] = new MButton("#", null, new ImageIcon("pics\\lattice.png"));
        buttonsArray[4][0] = new MButton("Clear", null, new ImageIcon("pics\\clear.png"));
        buttonsArray[4][1] = new MButton("Backspace", null, new ImageIcon("pics\\backspace.png"));
        buttonsArray[4][2] = new MButton("Enter", null, new ImageIcon("pics\\enter.png"));
    }

    private void creeateButtonsMap() {
        buttonsMap = new HashMap<>();
        for (int i = 0; i < buttonsArrayRows; i++) {
            for (int j = 0; j < buttonsArrayColumns; j++) {
                MButton mButton = buttonsArray[i][j];
                buttonsMap.put(mButton.getName(), mButton);
            }
        }
    }

    public MButton[][] getButtonsArray() {
        return buttonsArray;
    }

    public Map<String, MButton> getButtonsMap() {
        return buttonsMap;
    }

    public String getPreviousButtonName() {
        return previousButtonName;
    }

    public void setPreviousButtonName(String previousButtonName) {
        this.previousButtonName = previousButtonName;
    }

    public Boolean isFirstLetter() {
        return isFirstLetter;
    }

    public void setIsFirstLetter(Boolean first) {
        isFirstLetter = first;
    }

    public Boolean getFirstAction() {
        return isFirstAction;
    }

    public void setFirstAction(Boolean firstAction) {
        isFirstAction = firstAction;
    }

    public String getTypeMode() {
        return typeMode;
    }

    public void setTypeMode(String typeMode) {
        this.typeMode = typeMode;
        typeModeLabel.setText(this.typeMode);
    }

    public int getButtonsArrayRows() {
        return buttonsArrayRows;
    }

    public int getButtonsArrayColumns() {
        return buttonsArrayColumns;
    }

    public void setTypeModeLabel(JLabel typeModeLabel) {
        this.typeModeLabel = typeModeLabel;
        this.typeModeLabel.setText(typeMode);
    }

    public JTextComponent getMessage() {
        return message;
    }

    public void setMessage(JTextComponent message) {
        this.message = message;
    }

    public ActionContext getActionContext(String buttonName) {
        return buttonsMap.get(buttonName).getActionContext();
    }

    public String[] getValues(String buttonName) {
        return buttonsMap.get(buttonName).getValues();
    }
}