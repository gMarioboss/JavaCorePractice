package lesson10;

import java.util.*;

public class PhoneBook {

   private final Map<String, ArrayList<String>> phoneMap = new HashMap<>();

    void addNumber(String surname, String number) {
        if (phoneMap.containsKey(surname)) {
            phoneMap.get(surname).add(number);
        } else {
            ArrayList<String> numbers = new ArrayList<>();
            numbers.add(number);
            phoneMap.put(surname, numbers);
        }
    }

    void getNumber(String surname) {
        System.out.printf("Фамилия: %s, Номер телефона: %s%n", surname, phoneMap.get(surname));
    }
}
