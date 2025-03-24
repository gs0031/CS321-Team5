package graphics;

import fruitpie.InputHandeler;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GamePanel extends JPanel implements Runnable {

    final int maxScreenCol = 20;
    final int maxScreenRow = 16;
    int FPS = 120;

    InputHandeler keyH = new InputHandeler();
    Thread gameThread;

    float fruitXRatio = 0.5f;
    float fruitYRatio = 0.15f;

    public GamePanel() {
        this.setPreferredSize(new Dimension(960, 768));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyH);

        // Set layout to absolute
        this.setLayout(null);

        // Force UI to update layout
        SwingUtilities.invokeLater(() -> {
            this.revalidate();
            this.repaint();
        });
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {

            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000.0;

                if (remainingTime < 0) remainingTime = 0;
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void update() {

        if (fruitYRatio < 0.78f) {
            if (fruitXRatio > 0.1f && keyH.leftPressed) {
                fruitXRatio -= 0.01f;
            }
            if (fruitXRatio < 0.85f && keyH.rightPressed) {
                fruitXRatio += 0.01f;
            }
            if (keyH.dropPressed) {
                fruitYRatio += 0.05f;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();
        int tileSize = Math.min(width / maxScreenCol, height / maxScreenRow);

        // Background
        GradientPaint gradient = new GradientPaint(
                0, 0, new Color(255, 218, 185),
                0, height, new Color(255, 255, 153)
        );
        g2.setPaint(gradient);
        g2.fillRect(0, 0, width, height);

        // Fruit
        int fruitX = (int) (fruitXRatio * width);
        int fruitY = (int) (fruitYRatio * height);
        g2.setColor(Color.WHITE);
        g2.fillRect(fruitX, fruitY, tileSize, tileSize);

        // Borders
        int borderThickness = Math.max(tileSize / 5, 5);
        g2.setColor(Color.BLACK);
        g2.fillRect(tileSize, tileSize * 2, borderThickness, height - tileSize * 3);
        g2.fillRect(width - tileSize - borderThickness, tileSize * 2, borderThickness, height - tileSize * 3);
        g2.fillRect(tileSize, height - tileSize, width - tileSize * 2, borderThickness);

        g2.dispose();
    }
}
