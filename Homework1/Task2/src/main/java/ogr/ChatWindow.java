package ogr;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatWindow extends JFrame {

    private String WINDOW_TITLE = "Чат";
    
    private String login;
    private LogHandler logHandler;
    private String text = "";
    private JButton sendButton = new JButton("Отправить");
    private JLabel inputLabel = new JLabel("Введите сообщение:");
    private JTextField inputField = new JTextField();
    private JTextArea outputField = new JTextArea();
    private JPanel mainPanel = new JPanel(new GridLayout(1,2));
    private JPanel basementPanel = new JPanel(new GridLayout(3,1));

    ChatWindow(String login, String server, LogHandler logHandler) throws IOException{
        this.logHandler = logHandler;
        this.login = login;
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(WINDOW_TITLE);
        this.setSize(400,400);
        initWindow();



        mainPanel.add(outputField);
        basementPanel.add(inputLabel);
        basementPanel.add(inputField);
        basementPanel.add(sendButton);
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(basementPanel, BorderLayout.SOUTH);
        setVisible(true);
        this.pack();
    }

    private void initWindow() throws IOException{

        outputField.enableInputMethods(false);
        outputField.setBackground(Color.LIGHT_GRAY);
        String output = "";

        for (String string : logHandler.Read()) {

            output += string + "\n";
        }
        outputField.setText(output);



        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){

                String text = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss")).toString() + " "
                        + login + ": " + inputField.getText();
                try {
                    logHandler.Write(text);
                    outputField.append(text);
                    outputField.append("\n");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                inputField.setText("");
            }
        });
        inputField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss")).toString();
                    String msgText = dt + " " + login + ": " + inputField.getText();
                    try {
                        logHandler.Write(msgText);
                        outputField.append(msgText);
                        outputField.append("\n");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    inputField.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

    }
}
