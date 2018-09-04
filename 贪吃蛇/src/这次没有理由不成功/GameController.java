package 这次没有理由不成功;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener {
    private final Grid grid;
    private final GameView gameView;
    
    public GameController(Grid grid,GameView gameView) {
        // TODO Auto-generated constructor stub
        this.grid = grid;
        this.gameView = gameView;
    }
    
    public void run() {
        while(grid.nextRound()) {
            gameView.draw();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        gameView.showGameOver();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Snake s = grid.getSnake();
        if(e.getKeyCode() == KeyEvent.VK_W)
            s.changeDirection(Direction.UP);
        if(e.getKeyCode() == KeyEvent.VK_D)
            s.changeDirection(Direction.RIGHT);
        if(e.getKeyCode() == KeyEvent.VK_S)
            s.changeDirection(Direction.DOWN);
        if(e.getKeyCode() == KeyEvent.VK_A)
            s.changeDirection(Direction.LEFT);
            
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}