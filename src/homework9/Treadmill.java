package homework9;

public class Treadmill extends Obstacle {
    private int distance = (int) (Math.random() * 5) + 1;

    public int getDistance() {
        return distance;
    }

}

