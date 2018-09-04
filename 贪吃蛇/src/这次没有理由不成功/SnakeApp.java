package 这次没有理由不成功;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class SnakeApp {
    private GameView gameView;
    private GameController gameContronller;

    public void init() {
        Grid grid = new Grid(25, 20);

        JFrame window = new JFrame("贪吃蛇");

        Container contentPane = window.getContentPane();

        gameView = new GameView(grid);
        gameView.init();

        gameView.getCanvas().setPreferredSize(new Dimension(grid.getWidth() * 30, grid.getHeight() * 30));

        contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);
        
        gameContronller = new GameController(grid, gameView);
        window.addKeyListener(gameContronller);
        
        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        gameContronller.run();
    }

    public static void main(String[] args) {
        SnakeApp snakeApp = new SnakeApp();
        snakeApp.init();
    }

}
