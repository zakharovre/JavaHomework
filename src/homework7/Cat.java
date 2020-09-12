package homework7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate p) {
        if (p.getFood() >= appetite) {
            satiety = true;
            p.decreaseFood(appetite);
        } else
            System.out.println("Кот не сможет наесться, в тарелке осталось " + p.getFood() + " единиц еды.");
    }
}
