package homework6;

public abstract class Animal {
    protected int runLimit;
    protected float jumpHeight;


    public int getRunLimit() {
        return runLimit;
    }

    public void setRunLimit(int runLimit) {
        this.runLimit = runLimit;
    }

    public float getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public abstract void run(int distance);

    public abstract void jump(float height);

}

