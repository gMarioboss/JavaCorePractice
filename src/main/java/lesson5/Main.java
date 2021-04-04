package lesson5;

public class Main {
    static Employee employee1 = new Employee("Иван Иванович Иванов", 40, 80000,
            "+7989827512", "ivan@gmail.com", "Менеджер");
    static Employee employee2 = new Employee("Петр Петрович Петров", 32, 100000,
            "+7989827512", "petr@gmail.com", "Программист");
    static Employee employee3 = new Employee("Евгений Евгеньивич Евгений", 45, 200000,
            "+7989827512", "evgeniy@gmail.com", "Директор");
    static Employee employee4 = new Employee("Максим Максимович Максимов", 25, 100000,
            "+7989827512", "maksim@gmail.com", "Программист");
    static Employee employee5 = new Employee("Алексей Алексеев Алексев", 29, 70000,
            "+7989827512", "alex@gmail.com", "HR");

    static Employee[] arrayEmployees = {employee1, employee2, employee3, employee4, employee5};

    public static void main(String[] args) {
            showInfo();
            showOldEmployees();
    }

    private static void showInfo() {
        for (int i = 0; i < arrayEmployees.length; i++) {
            arrayEmployees[i].printInfo();
        }
    }

    private static void showOldEmployees() {
        System.out.println("\nПоказать сотрудников старше 40 лет:");
        for (int i = 0; i < arrayEmployees.length; i++) {
            if (arrayEmployees[i].getAge() >= 40) {
                arrayEmployees[i].printInfo();
            }
        }
    }

}
