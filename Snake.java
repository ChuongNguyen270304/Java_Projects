public class Snake{
    private Point[] points;
    private AudColor color = AudColor.BLUE;
    public Snake(int x, int y, int length){
        if (length <= 0){
            throw new IllegalArgumentException("Die Laenge muss positiv sein");
        }
        this.points = new Point[length];
        Point start_point = new Point(x, y);
        this.points[0] = start_point;
    }
    public Snake(int x, int y){
        this(x,y,5);
    }
    public void paint(AudGraphics g){
        g.setColor(this.color);
        for(int i =0;i<this.points.length;i++){
            if (this.points[i] == null){
                continue;
            } else {
                g.fillRect(this.points[i].getX() * SnakeGame.SQUARE_SIZE, this.points[i].getY() * SnakeGame.SQUARE_SIZE,
                        SnakeGame.SQUARE_SIZE, SnakeGame.SQUARE_SIZE);
            }
        }
    }
    public enum Direction{
        RIGHT, DOWN, LEFT, UP
    }
    private Direction nextDirection = Direction.RIGHT;
    public Direction getDirection(){
        return this.nextDirection;
    }
    public void setDirection(Direction Direction){
        this.nextDirection = Direction;
    }
    private Direction lastDirection = Direction.RIGHT;
    public void step(){
        int oldX = this.points[0].getX();
        int oldY = this.points[0].getY();
        System.arraycopy(this.points,0,this.points,1,this.points.length-1);
        if (this.nextDirection == Direction.RIGHT){
            int newX = oldX + 1;
            int newY = oldY;
            this.points[0] = new Point(newX, newY);
        } else if (this.nextDirection == Direction.DOWN){
            int newY = oldY +1;
            int newX = oldX;
            this.points[0] = new Point(newX, newY);
        } else if (this.nextDirection == Direction.LEFT){
            int newX = oldX -1;
            int newY = oldY;
            this.points[0] = new Point(newX, newY);
        } else if (this.nextDirection == Direction.UP) {
            int newY = oldY -1;
            int newX = oldX;
            this.points[0] = new Point(newX, newY);
        }
        this.lastDirection = this.nextDirection;
    }
    public void setNextDirection(Direction direction){
        if (Math.abs(direction.ordinal() - this.lastDirection.ordinal()) == 2){
            return;
        }
        this.nextDirection = direction;
    }
    public boolean collidesWith(int x, int y) {
        for (Point point : points) {
            if (point != null && point.getX() == x && point.getY() == y) {
                return true;
            }
        }
        return false;
    }
    public boolean collidesWith(GameItem item){
        return collidesWith(item.getPosition().getX(), item.getPosition().getY());
    }
    public boolean collidesWithSelf(){
        for(int i =1;i<points.length-1;i++){
            if(points[i] != null && points[0].getX() == points[i].getX()
            && points[0].getY() == points[i].getY()){
                return true;
            }
        }
        return false;
    }
    public void grow(int amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Der Wert muss positiv sein");
        }

        Point[] newPoints = new Point[this.points.length+amount];
        System.arraycopy(this.points,0,newPoints,0,this.points.length);
        this.points = newPoints;
    }
}
