package ru.littlebigbro;

public class ActionContext {
    private long lastTime = System.currentTimeMillis();
    private int count = 0;
    private int countMode = 0;

    public ActionContext() {
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountMode() {
        return countMode;
    }

    public void setCountMode(int countMode) {
        this.countMode = countMode;
    }
}
