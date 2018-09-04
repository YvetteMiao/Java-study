package 这次没有理由不成功;

/**
 * 贪吃蛇前进的方向
 */
public enum Direction {
    UP(0),RIGHT(1),DOWN(2),LEFT(3);
    
    private final int directionCode;
    
    public int directionCode() {
        return directionCode;
    }
    
    Direction(int directionCode){
        this.directionCode = directionCode;
    }
    
    public boolean compatibleWith(Direction direction) {
        if(this.directionCode == 0 && direction.directionCode != 2)
            return true;
        if(this.directionCode == 1 && direction.directionCode != 3)
            return true;
        if(this.directionCode == 2 && direction.directionCode != 0)
            return true;
        if(this.directionCode == 3 && direction.directionCode != 1)
            return true;
        return false;
    }
}