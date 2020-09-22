package homework9;

public class Human implements RunAndJump {
    private String name;
    private String objType = "Человек";
    private int jumpLimit = (int) (Math.random() * 5) + 1;
    private int runLimit = (int) (Math.random() * 5) + 1;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getObjType() {
        return objType;
    }

    public static void relax() {
        System.out.println("Do nothing");
    }

    @Override
    public boolean run(Treadmill treadmill) {
        if (runLimit >= treadmill.getDistance()) {
            System.out.println(objType + " " + name + " преодолел дистанцию " + treadmill.getDistance());
            return true;
        } else
            System.out.println(objType + " " + name + " не смог пробежать " + treadmill.getDistance());
        return false;
    }

    @Override
    public boolean jump(Wall wall) {
        if (runLimit >= wall.getHeight()) {
            System.out.println(objType + " " + name + " перепрыгнул высоту " + wall.getHeight());
            return true;
        } else
            System.out.println(objType + " " + name + " не смог перепрыгнуть " + wall.getHeight());
        return false;
    }
}


