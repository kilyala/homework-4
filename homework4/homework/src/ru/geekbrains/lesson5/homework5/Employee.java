package ru.geekbrains.lesson5.homework5;

public class Employee {

    String name;
    int age;
    String position;
    String email;
    String phoneNumber;
    int salary;

    Employee(String name, int age, String position, String email, String phoneNumber, int salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ФИО: " + name + "\n" + "Возраст: " + age + "\n" + "Должность: " + position + "\n" + "Почта: " + email + "\n" + "Номер телефона: " + phoneNumber + "\n" + "Зарплата: " + salary + "\n";

    }
    public void print(){
        System.out.println(this);
    }


    public static void main(String[] args) {

        Employee[] members = new Employee[5];
        members[0] = new Employee("Ivanov Ivan", 25, "Manager", "ivanych@mail", "1234567", 30000);
        members[1] = new Employee("Petrov Petr", 45, "Top manager", "petrovych@mail", "7658345", 50000);
        members[2] = new Employee("Sergeev Sergey", 30, "Accountant", "serych@mail", "3498125", 40000);
        members[3] = new Employee("Alexeev Alexey", 58, "Babyfacesitter", "leha@mail", "555752349", 80000);
        members[4] = new Employee("Smirnov Boris", 36, "Programmer", "boryan@mail", "3215467", 200000);

        for (Employee member : members) if (member.age > 40) member.print();

    }


}
