package org.logic;

import org.panels.BasementPanel;
import org.panels.GamePanel;
import org.panels.GameSettingsPanel;
import org.window.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private JFrame mainFrame;

    private ActionListener startListener, settingsListener, stopListener;

    private JPanel basementPannel, workPannel,
            gamePanel, gameSettingsPanel;

    {
        startListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workPannel = gamePanel;
                mainFrame.setVisible(false);
                mainFrame = new MainWindow(workPannel, basementPannel);

            }
        };

        settingsListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workPannel = gameSettingsPanel;
                mainFrame.setVisible(false);
                mainFrame = new MainWindow(workPannel, basementPannel);
            }
        };

        stopListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
    }

    public Controller() {



        basementPannel = new BasementPanel(startListener, settingsListener, stopListener);
        gamePanel = new GamePanel();
        gameSettingsPanel = new GameSettingsPanel();

        workPannel = gameSettingsPanel;


    }

    public void run() {
        try {

        mainFrame = new MainWindow(workPannel, basementPannel);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }


    }


}
