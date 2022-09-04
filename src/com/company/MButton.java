package com.company;

import javax.swing.*;

public class MButton {
    private String name;
    private String[] values;
    private ImageIcon icon;

    public MButton(String name, String[] values, ImageIcon icon) {
        this.name = name;
        this.values = values;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}
