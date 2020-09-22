package homework9;

public class Robot implements RunAndJump {
    private String name;
    private String objType = "Робот";
    private int jumpLimit = (int) (Math.random() * 5) + 1;
    private int runLimit = (int) (Math.random() * 5) + 1;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getObjType() {
        return objType;
    }

    public static void work() {
        System.out.println("Hardworking");
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

