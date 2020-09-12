package homework7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
    public void addFood(int amount){
        food+=amount;
        System.out.println("Добавили в тврелку " + amount + " единиц еды");
    }
}
