package 这次没有理由不成功;

import java.util.Arrays;
import java.util.Random;

public class Grid {
    public final boolean[][] status;
    private final int width;
    private final int height;

    private Snake snake;
    private Node egg;
//    private Direction snakeDirection = Direction.RIGHT;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;

        status = new boolean[width][height];
        for (int i = 0; i < width; i++) {
            Arrays.fill(status[i], false);
        }

        initSnake();
        createEgg();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Node getEgg() {
        return egg;
    }

    public Snake getSnake() {
        return snake;
    }

    private Snake initSnake() {
        this.snake = new Snake();

        for (int i = 0; i < width / 3; i++) {
            this.snake.addTail(new Node((width / 3) - i, height / 2));
        }
        
//        this.snake.addTail(new Node(3,0));
//        this.snake.addTail(new Node(2,0));
//        this.snake.addTail(new Node(1,0));
//        this.snake.addTail(new Node(0,0));

        for (Node n : this.snake.getBody()) {
            status[n.getX()][n.getY()] = true;
        }

        return this.snake;
    }

    private Node createEgg() {
        int x, y;
        while (true) {
            x = new Random().nextInt(width);
            y = new Random().nextInt(height);
            if (status[x][y] == false)
                break;
        }
        return this.egg = new Node(x, y);
    }

    public boolean nextRound() {
        Node tail = this.snake.move(this.snake.getDirection());
        if (isLegal(this.snake.getHead())) {
            if (this.snake.getHead().equals(this.egg)) {
                this.snake.addTail(tail);
                refreshStatus();
                createEgg();
            }
            refreshStatus();
            return true;
        } else
            return false;
    }

    private boolean isLegal(Node head) {
        if (head.getX() < 0 || head.getX() >= width)
            return false;
        if (head.getY() < 0 || head.getY() >= height)
            return false;
        try {
            if (status[head.getX()][head.getY()])
                return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO: handle exception
        }
        return true;
    }

    private void refreshStatus() {
        for (int i = 0; i < width; i++) {
            Arrays.fill(status[i], false);
        }
        for (Node n : this.snake.getBody()) {
            status[n.getX()][n.getY()] = true;
        }
    }
    
//    public void changeDirection(Direction newDirection) {
//        if(this.snakeDirection.compatibleWith(newDirection))
//            this.snakeDirection = newDirection;
//    }
}