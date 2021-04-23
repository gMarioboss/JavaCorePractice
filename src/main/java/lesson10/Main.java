package lesson10;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        findDuplicates();
        phoneNumbers();
    }

    private static void findDuplicates() {
        String[] wordsArray = {"File", "Edit", "Navigate", "File", "Analyze", "Refactor", "Run", "Edit",
                "Help", "Edit", "Git", "Code", "Help", "Run"};
        Set<String> uniqueSetList = new TreeSet<>();

        Collections.addAll(uniqueSetList, wordsArray);
        System.out.println(uniqueSetList);

        Iterator<String> iterator = uniqueSetList.iterator();
        int count = 0;

        while (iterator.hasNext()) {
            String setWord = iterator.next();
            count = 0;
            for (String arrayWord : wordsArray) {
                if (setWord.equals(arrayWord)) {
                    count++;
                }
            }
            System.out.printf("Слово [%s] встречается %d раз%n", setWord, count);
        }
        System.out.println();
    }

    private static void phoneNumbers() {
       PhoneBook phoneBook = new PhoneBook();
        phoneBook.addNumber("Ivanov", "+712932183");
        phoneBook.addNumber("Ivanov", "+415125163");
        phoneBook.addNumber("Kuznetsov", "+312932183");
        phoneBook.addNumber("Petrov", "+212932183");
        phoneBook.addNumber("Korolyov", "+812932183");
        phoneBook.addNumber("Korolyov", "+102");
        phoneBook.addNumber("Korolyov", "+38777124");
        phoneBook.addNumber("Popov", "+912932183");

        phoneBook.getNumber("Ivanov");
        phoneBook.getNumber("Kuznetsov");
        phoneBook.getNumber("Petrov");
        phoneBook.getNumber("Korolyov");
        phoneBook.getNumber("Popov");

    }
}
