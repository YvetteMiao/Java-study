package 这次没有理由不成功;

import java.util.LinkedList;

public class Snake {
    private LinkedList<Node> body = new LinkedList<>();
    
    private Direction snakeDirection = Direction.RIGHT;


//    public Node eat(Node egg) {
//        if(isNeighbor(egg, this.getHead())) {
//            this.body.addFirst(egg);
//            return egg;
//        } else
//            return null;
//    }
//    
//    private boolean isNeighbor(Node a, Node b) {
//        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) == 1;
//    }

    public Direction getDirection() {
        return snakeDirection;
    }
    public Node move(Direction direction) {
        switch (direction) {
        case UP:
            this.body.addFirst(new Node(getHead().getX(), getHead().getY() - 1));
            break;
        case RIGHT:
            this.body.addFirst(new Node(getHead().getX() + 1, getHead().getY()));
            break;
        case DOWN:
            this.body.addFirst(new Node(getHead().getX(), getHead().getY() + 1));
            break;
        case LEFT:
            this.body.addFirst(new Node(getHead().getX() - 1, getHead().getY()));
            break;

        default:
            break;
        }
        return this.body.removeLast();
    }

    public Node getHead() {
        return body.getFirst();
    }

    public Node addTail(Node area) {
        this.body.addLast(area);
        return area;
    }

    public LinkedList<Node> getBody() {
        return this.body;
    }
    
    public void changeDirection(Direction newDirection) {
        if(this.snakeDirection.compatibleWith(newDirection))
            this.snakeDirection = newDirection;
    }
}
