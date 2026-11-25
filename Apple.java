public class Apple extends GameItem{
    private static int nextValue = 1;
    private final int VALUE;
    public Apple(int x, int y) {
        super(x, y);
        VALUE=nextValue++;
    }
    public int getValue(){
        return this.VALUE;
    }
    @Override
    public void paint(AudGraphics g) {
        g.setColor(AudColor.RED);
        g.fillOval(getPosition().getX() * SnakeGame.SQUARE_SIZE, getPosition().getY() * SnakeGame.SQUARE_SIZE,
                SnakeGame.SQUARE_SIZE,SnakeGame.SQUARE_SIZE);
    }
}
