package ogr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ConnectWindow extends JFrame {
    

    private String WINDOW_TITLE = "Подключение к чату";
    private LogHandler logHandler;

    JLabel loginLabel = new JLabel("Логин:");
    JTextField loginField = new JTextField(10);
    JTextField serverField = new JTextField();
    JButton buttonConnect = new JButton("Подключиться");

    JPanel jPanel = new JPanel(new FlowLayout());

    ConnectWindow(LogHandler logHandler){
        this.logHandler = logHandler;

        setTitle(WINDOW_TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jPanel.add(loginLabel);
        jPanel.add(loginField);
        jPanel.add(buttonConnect);
        
        add(jPanel);

        initWindow();


        setVisible(true);
        this.pack();
    }

    private void initWindow(){
        buttonConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String login = loginField.getText();
                String server = serverField.getText();
                try {
                    new ChatWindow(login, server, logHandler);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                setVisible(false);
            }
        });

    }
}