package org.window;

import javax.swing.*;
import java.awt.*;


public class MainWindow extends JFrame{

    public JPanel mainPanel, workPanel, basementPanel;



    public MainWindow(JPanel workPanel, JPanel basementPanel) throws HeadlessException {

        windowInit();
        panelInit();

        this.workPanel = workPanel;
        this.basementPanel = basementPanel;


        this.mainPanel.add(this.workPanel, BorderLayout.CENTER);
        this.mainPanel.add(this.basementPanel, BorderLayout.SOUTH);
        super.add(mainPanel);
        super.pack();

    }

    private void windowInit () {
        super.setTitle("TicTacToe Game");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(true);
        super.setVisible(true);
        super.setIconImage(new ImageIcon("icon.png").getImage());
        super.setLayout(new BorderLayout());
    }

    private void panelInit (){
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.yellow);
        mainPanel.setLayout(new BorderLayout());

    }

    public JPanel getWorkPanel() {
        return workPanel;
    }

    public void setWorkPanel(JPanel workPanel) {
        this.workPanel = workPanel;
    }
}
