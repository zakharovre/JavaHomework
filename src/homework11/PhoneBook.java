package homework11;

import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, String> map = new HashMap<>();

    public void add(String name, String number) {
        if (map.containsKey(name))
            map.put(name, map.get(name) + " , " + number);
        else
            map.put(name, number);
    }

    public void get(String name){
        System.out.printf("Имя : %s; Номер телефона : %s%n",name,map.get(name));
    }
}

