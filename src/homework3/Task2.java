package homework3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String word = words[(int)(Math.random()*25)];
        String guess;
        Scanner scanner = new Scanner(System.in);
        while(true){
            char[] output = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',};
            System.out.println("Попробуйте угадать слово");
            guess = scanner.nextLine();
            if(guess.equals(word)){
                System.out.println("Поздравляю, вы угадали слово!");
                break;
            }
            for(int i = 0; i < Math.min(guess.length(), word.length());i++) {
                if (word.charAt(i) == guess.charAt(i))
                    output[i] = word.charAt(i);
            }
            System.out.println(output);
        }
    }
}
