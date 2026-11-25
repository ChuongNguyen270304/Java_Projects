import java.util.Random;
class SnakeGame extends AudGameWindow{
    public static final int SQUARE_SIZE = 16;
    public static final int STEP_TIME = 100;
    public static final int GROW_AMOUNT = 5;
    private int score;
    private int width;
    private int height;
    private long lastSnakeUpdate;
    Snake snake;
    Brick[] wall;
    Apple apple;
    public SnakeGame(){
        super();
        this.lastSnakeUpdate = System.currentTimeMillis();
        this.width = getGameAreaWidth() / SQUARE_SIZE;
        this.height = getGameAreaHeight() / SQUARE_SIZE;
        this.score = 0;
        setTitle("AuD-Snake - Score: " + this.score);
        this.snake = new Snake(this.width / 2, this.height /2);

        wall = new Brick[2*width + 2*(height-2)];
        int index=0;

        for(int x=0;x<width;x++){
            wall[index++] = new Brick(x,0);
            wall[index++] = new Brick(x,height-1);
        }

        for(int y=1;y<height-1;y++){
            wall[index++] = new Brick(0,y);
            wall[index++] = new Brick(width-1,y);
        }
        createNewApple();
    }
    @Override
    public void updateGame(long time) {
        while((time-lastSnakeUpdate) >= STEP_TIME){
            snake.step();
            checkCollisions();
            lastSnakeUpdate+=STEP_TIME;
        }
    }

    @Override
    public void paintGame(AudGraphics g) {
        g.setColor(AudColor.WHITE);
        g.fillRect(0, 0, getGameAreaWidth(), getGameAreaHeight());
        this.snake.paint(g);
        for(Brick brick: this.wall){
            brick.paint(g);
        }
        apple.paint(g);
    }

    @Override
    public void handleInput(int keyCode) {
        if(keyCode == KeyEvent.VK_RIGHT){
            this.snake.setNextDirection(Snake.Direction.RIGHT);
        } else if (keyCode == KeyEvent.VK_DOWN){
            this.snake.setNextDirection(Snake.Direction.DOWN);
        } else if (keyCode == KeyEvent.VK_LEFT){
            this.snake.setNextDirection(Snake.Direction.LEFT);
        } else if (keyCode == KeyEvent.VK_UP){
            this.snake.setNextDirection(Snake.Direction.UP);
        }
    }
    private void checkCollisions(){
        for(Brick brick: wall){
            if(snake.collidesWith(brick) || snake.collidesWithSelf()){
                stop();
                showDialog("You died! Score: " + this.score);
                break;
            }
        }
        if(snake.collidesWith(apple)){
            this.score+=apple.getValue();
            setTitle("AuD Snake - Score: " + this.score);
            snake.grow(GROW_AMOUNT);
            createNewApple();
        }
    }
    private void createNewApple(){
        Random rand = new Random();
        int x,y;
        do {
            x = rand.nextInt(2,width-2);
            y = rand.nextInt(2,height-2);
        } while (snake.collidesWith(x,y));

        apple = new Apple(x,y);
    }
    public static void main(String[] args){
        SnakeGame snakeGame = new SnakeGame();
        snakeGame.start();

    }
}
