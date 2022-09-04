package com.company;

public class State {
    private String previousButtonName = "";
    private Boolean isFirst = false;

    public String getPreviousButtonName() {
        return previousButtonName;
    }

    public void setPreviousButtonName(String previousButtonName) {
        this.previousButtonName = previousButtonName;
    }

    public Boolean getFirst() {
        return isFirst;
    }

    public void setFirst(Boolean first) {
        isFirst = first;
    }
}
