package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.animal.Cat;

public class Main {

    public static void main(String[] args) {
        Cat tom = new Cat("Black", 1);
        tom.setName("Puss");

        tom.meow();
        int i = 3;

        changeAgeForCat(tom, i);

        System.out.println(tom.getAge());
    }

    static void changeAgeForCat(Cat cat, int age) {
        cat.setAge(age);
    }
}