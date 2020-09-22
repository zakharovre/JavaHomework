package homework9;

public class Task {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Пушок");
        Cat cat2 = new Cat("Жирок");
        Human hum1 = new Human("Виктор");
        Human hum2 = new Human("Митя");
        Robot rob1 = new Robot("R2-D2");
        Robot rob2 = new Robot("C-3PO");
        RunAndJump[] rj = {cat1, cat2, hum1, hum2, rob1, rob2};

        Obstacle[] obs = new Obstacle[6];
        for (int i = 0; i < obs.length; i += 2) {
            obs[i] = new Wall();
            obs[i + 1] = new Treadmill();
        }

        for (RunAndJump runAndJump : rj) {
            for (Obstacle ob : obs) {
                if (ob instanceof Treadmill) {
                    if (!runAndJump.run((Treadmill) ob))
                        break;
                }
                if (ob instanceof Wall) {
                    if (!runAndJump.jump((Wall) ob))
                        break;
                }
            }
        }
    }
}


