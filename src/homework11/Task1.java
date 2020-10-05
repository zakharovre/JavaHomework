package homework11;

import java.util.ArrayList;
import java.util.Arrays;


public class Task1 {
    public static void main(String[] args) {
        String[] words = {"cat", "pet", "job", "dog", "cat", "dog", "sun", "dog", "top", "mad", "mug", "sit", "pet", "sun", "top"};
        System.out.println("Uniq words: " + uniq(words));
        count(words);
    }

    private static void count(String[] arr) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        ArrayList<String> checked = new ArrayList<>();
        for (String word : list) {
            int count = 0;
            if (!checked.contains(word)) {
                System.out.print(word + " : ");
                for (String s : list) {
                    if (word.equals(s))
                        count++;
                }
                checked.add(word);
                System.out.println(count);
            }
        }
    }

    private static ArrayList<String> uniq(String[] arr) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        ArrayList<String> uniq = new ArrayList<>();
        for (String s : list) {
            if (list.indexOf(s) == list.lastIndexOf(s))
                uniq.add(s);
        }
        return uniq;
    }
}
