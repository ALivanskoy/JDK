package org;


import org.logic.Controller;
import org.window.MainWindow;

public class Main {
    public static void main(String[] args) {

        //MainWindow mainWindow = new MainWindow();
        Controller controller = new Controller();

        controller.run();
    }
}