package homework6;

public class Task {
    public static void main(String[] args) {
        Animal[] someGroup = new Animal[10];
        for (int i = 0; i < 5; i++)
            someGroup[i] = new Cat();
        for (int i = 5; i < 10; i++)
            someGroup[i] = new Dog();
        for (Animal animal : someGroup) {
            if (animal instanceof Cat)
                animal.run(200);
            else
                animal.run(500);
            if (animal instanceof Cat)
                animal.jump(2.0f);
            else
                animal.jump(0.7f);
            if (animal instanceof Dog)
                ((Dog) animal).swim(10);
            else
                System.out.println("Коты не умеют плавать");
            System.out.println("------------------------------");
        }
    }
}

