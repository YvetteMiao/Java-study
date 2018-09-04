package 这次没有理由不成功;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameView {
    private final Grid grid;
    private JPanel canvas;

    public GameView(Grid grid) {
        this.grid = grid;
    }

    public void init() {
        canvas = new JPanel() {

            /**
             * 
             */
            private static final long serialVersionUID = 1L;

            @Override
            public void paint(Graphics graphics) {
                super.paintComponent(graphics);
                drawGridBackground(graphics);
                drawSnake(graphics, grid.getSnake());
                drawEgg(graphics, grid.getEgg());
            }

        };
    }

    public void draw() {
        canvas.repaint();
    }

    public JPanel getCanvas() {
        return canvas;
    }

    public void drawEgg(Graphics graphics, Node egg) {
        graphics.setColor(new Color(255, 255, 255));
        graphics.fillOval(egg.getX() * 30 + 3, egg.getY() * 30 + 3, 24, 24);
    }

    public void drawSnake(Graphics graphics, Snake snake) {
        graphics.setColor(new Color(255, 255, 255));
        for (Node bodypart : snake.getBody()) {
            graphics.fillRect(bodypart.getX() * 30 + 3, bodypart.getY() * 30 + 3, 24, 24);
        }
        graphics.setColor(new Color(150, 150, 150));
        graphics.fillRect(snake.getHead().getX() * 30 + 3, snake.getHead().getY() * 30 + 3, 24, 24);
    }

    public void drawGridBackground(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0));
        graphics.fillRect(0, 0, grid.getWidth() * 30, grid.getHeight() * 30);
    }
    
    public void showGameOver() {
        JOptionPane.showMessageDialog(null, "游戏结束", "贪吃蛇", JOptionPane.INFORMATION_MESSAGE);
    }
}
