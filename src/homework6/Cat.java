package homework6;

public class Cat extends Animal {

    public Cat() {
        runLimit = (int) (Math.random() * 200) + 100;
        jumpHeight = ((int) (Math.random() * 10) + 15) / 10.0f;
    }

    @Override
    public void run(int distance) {
        System.out.println("Кот сможет пробежать " + getRunLimit() + " метров.");
        System.out.println("Дистанция забега: " + distance + " метров.");
        if (distance > getRunLimit())
            System.out.println("Провал");
        else
            System.out.println("Успех");
    }

    @Override
    public void jump(float height) {
        System.out.println("Кот сможет перепрыгнуть " + getJumpHeight() + " метров.");
        System.out.println("Высота препятствия: " + height + " метров.");
        if (height > getJumpHeight())
            System.out.println("Провал");
        else
            System.out.println("Успех");
    }
}

