package homework7;

public class Task {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        Cat[] someCats = new Cat[10];
        for (int i = 0; i < someCats.length; i++)
            someCats[i] = new Cat("Кот №" + (i + 1), 15);
        for (Cat someCat : someCats) {
            someCat.eat(plate);
            System.out.println(someCat.getName() + " сыт: " + someCat.isSatiety());
        }
        plate.addFood(50);
        plate.info();
        for (Cat someCat : someCats) {
            if (!someCat.isSatiety()) {
                someCat.eat(plate);
                System.out.println(someCat.getName() + " сыт: " + someCat.isSatiety());
            }
        }
        plate.info();
    }
}
