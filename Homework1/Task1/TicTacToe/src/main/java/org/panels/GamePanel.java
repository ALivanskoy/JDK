package org.panels;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private Dimension dimension;

    public int panelWidth, panelHeight,
            cellsNumber, cellHeight, cellWidth,
            sizeX,sizeY;

    public GamePanel() {

        dimension = new Dimension(500,250);
        cellsNumber = 3;
        super.setBackground(Color.blue);
        super.setPreferredSize(dimension);
        this.sizeX = dimension.width;
        this.sizeY = dimension.height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        panelWidth = this.getWidth();
        panelHeight = this.getHeight();
        cellHeight = panelHeight / this.cellsNumber;
        cellWidth = panelWidth / this.cellsNumber;

        g.setColor(Color.BLACK);
        for (int h = 0; h < this.sizeX; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int h = 0; h < this.sizeY; h++) {
            int x = h * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        repaint();
    }

    void startNewGame(boolean mode, int size_x, int size_y, int win_len){
        sizeX = size_x;
        sizeY = size_y;
        repaint();
    }

}
