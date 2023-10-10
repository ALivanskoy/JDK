package org.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BasementPanel extends JPanel {

    private final JButton startButton, settingsButton, stopButton;

    public BasementPanel(ActionListener startButtonActionListener, ActionListener settingsButtonActionListener, ActionListener stopButtonActionListener) {
        super.setLayout(new FlowLayout(FlowLayout.CENTER, 10 ,20));
        super.setPreferredSize(new Dimension(500,50));
        super.setBackground(Color.darkGray);

        startButton = new JButton("Старт");
        setFocusable(false);
        startButton.addActionListener(startButtonActionListener);

        settingsButton = new JButton("Настройки");
        setFocusable(false);
        settingsButton.addActionListener(settingsButtonActionListener);

        stopButton = new JButton("Выход");
        setFocusable(false);
        stopButton.addActionListener(stopButtonActionListener);

        this.add(startButton);
        this.add(settingsButton);
        this.add(stopButton);

    }

    /*
    public void setStartButtonListener(ActionListener actionListener) {
        this.startButton.addActionListener(actionListener);
    }

    public void setSettingsButtonListener (ActionListener actionListener) {
        this.settingsButton.addActionListener(actionListener);
    }

    public void setStopButtonListener (ActionListener actionListener) {
        this.stopButton.addActionListener(actionListener);
    } */

}
