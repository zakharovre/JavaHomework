package homework6;

public class Dog extends Animal {
    private int swimLimit;

    public Dog() {
        runLimit = (int) (Math.random() * 200) + 400;
        jumpHeight = ((int) (Math.random() * 7) + 3) / 10.0f;
        swimLimit = (int) (Math.random() * 10) + 5;
    }

    public int getSwimLimit() {
        return swimLimit;
    }

    public void setSwimLimit(int swimLimit) {
        this.swimLimit = swimLimit;
    }

    @Override
    public void run(int distance) {
        System.out.println("Собака сможет пробежать " + getRunLimit() + " метров.");
        System.out.println("Дистанция заплыва: " + distance + " метров.");
        if (distance > getRunLimit())
            System.out.println("Провал");
        else
            System.out.println("Успех");
    }

    @Override
    public void jump(float height) {
        System.out.println("Собака сможет перепрыгнуть " + getJumpHeight() + " метров.");
        System.out.println("Высота препятствия: " + height + " метров.");
        if (height > getJumpHeight())
            System.out.println("Провал");
        else
            System.out.println("Успех");
    }

    public void swim(int distance) {
        System.out.println("Собака сможет проплыть " + getSwimLimit() + " метров.");
        System.out.println("Дистанция забега: " + distance + " метров.");
        if (distance > getSwimLimit())
            System.out.println("Провал");
        else
            System.out.println("Успех");
    }
}

