package homework11;

public class Task2 {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Витя","555-55-55");
        pb.add("Миша","321-54-87");
        pb.add("Ваня","557-98-74");
        pb.add("Миша","777-78-78");
        pb.get("Витя");
        pb.get("Миша");
    }
}

