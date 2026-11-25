public class Brick extends GameItem{

    public Brick(int x, int y) {
        super(x, y);
    }

    @Override
    public void paint(AudGraphics g) {
        g.setColor(AudColor.GRAY);
        int width_brick = getPosition().getX() * SnakeGame.SQUARE_SIZE;
        int heigt_brick = getPosition().getY() * SnakeGame.SQUARE_SIZE;
        g.fillRect(width_brick, heigt_brick, SnakeGame.SQUARE_SIZE, SnakeGame.SQUARE_SIZE);
    }
}
