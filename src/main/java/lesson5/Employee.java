package lesson5;

public class Employee {
    private int age;

    protected double salary;
    protected String name;
    protected String phone;
    protected String email;
    protected String position;

    public Employee(String name, int age, double salary, String phone, String email, String position) {
        this.age = age;
        this.salary = salary;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.position = position;
    }

    void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Сотрудник: " + name +
                ", Возраст: " + age +
                ", Зарплата: " + salary +
                ", Телефон: " + phone +
                ", E-mail: " + email +
                ", Должность: " + position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


