package com.company;

import javax.swing.*;

public class ButtonsSetups {
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

    public static final int arrayRows = 5;
    public static final int arrayColumns = 3;
    public static MButton[][] getButtonsArray() {
        MButton[][] arr = new MButton[5][3];
        arr[0][0] = new MButton(ONE, new String[]{".", ",", "-", "?", "!", "@", "(", ")", "/", ONE}, new ImageIcon("pics\\1.png"));
        arr[0][1] = new MButton(TWO, new String[]{"а", "б", "в", "г", TWO}, new ImageIcon("pics\\2.png"));
        arr[0][2] = new MButton(THREE, new String[]{"д", "е", "ё", "ж", "з", THREE}, new ImageIcon("pics\\3.png"));
        arr[1][0] = new MButton(FOUR, new String[]{"и", "й", "к", "л", FOUR}, new ImageIcon("pics\\4.png"));
        arr[1][1] = new MButton(FIVE, new String[]{"м", "н", "о", "п", FIVE}, new ImageIcon("pics\\5.png"));
        arr[1][2] = new MButton(SIX, new String[]{"р", "с", "т", "у", SIX}, new ImageIcon("pics\\6.png"));
        arr[2][0] = new MButton(SEVEN, new String[]{"ф", "х", "ц", "ч", SEVEN}, new ImageIcon("pics\\7.png"));
        arr[2][1] = new MButton(EIGHT, new String[]{"ш", "щ", "ъ", "ы", EIGHT}, new ImageIcon("pics\\8.png"));
        arr[2][2] = new MButton(NINE, new String[]{"ь", "э", "ю", "я", NINE}, new ImageIcon("pics\\9.png"));
        arr[3][0] = new MButton("*", new String[]{"Abc", "abc", "ABC", "123"}, new ImageIcon("pics\\star.png"));
        arr[3][1] = new MButton(ZERO, new String[]{"+", "=", "<", ">", "$", "%", ZERO}, new ImageIcon("pics\\0.png"));
        arr[3][2] = new MButton("#", null, new ImageIcon("pics\\lattice.png"));
        arr[4][0] = new MButton("Clear", null, new ImageIcon("pics\\clear.png"));
        arr[4][1] = new MButton("Backspace", null, new ImageIcon("pics\\backspace.png"));
        arr[4][2] = new MButton("Enter", null, new ImageIcon("pics\\enter.png"));
        return arr;
    }
}
