package homework3;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int guessedNumber, guess;
        int gameRestart = 1;
        Scanner scanner = new Scanner(System.in);
        while (gameRestart==1) {
            int tries = 3;
            guessedNumber = (int) (Math.random() * 10);
            while (tries>0) {
                System.out.println("Угадайте число от 0 до 9. Осталось попыток " + tries);
                while(!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println("Введите число от 0 до 9!");
                }
                guess = scanner.nextInt();

                if (guess > guessedNumber) {
                    System.out.println("Загаданное число меньше");
                    tries--;
                } else if (guess < guessedNumber) {
                    System.out.println("Загаданное число больше");
                    tries--;
                } else {
                    System.out.println("Вы угадали число " + guessedNumber);
                    break;
                }
                if (tries == 0) {
                    System.out.println("Вы не угалали число за 3 попытки, это было число: " + guessedNumber);
                }
            }
            System.out.println("Повторить игру еще раз? 1-да, 0-нет");
            gameRestart = scanner.nextInt();
        }
    }
}