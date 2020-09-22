package homework9;

public class Wall extends Obstacle {
    private int height = (int) (Math.random() * 5) + 1;

    public int getHeight() {
        return height;
    }
}

