package ru.littlebigbro;

public class Application {
    public static void run() {
        ApplicationContext applicationContext = new ApplicationContext();
        Gui.create(applicationContext);
    }
}
