package ru.geekbrains.lesson5.animal;

public class Cat {

    private String name = "Bob";
    private String color;

    private int age;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;

    }

    public Cat(String color, int age) {
        this.color = color;
        this.age = age;

    }

    public void meow() {
        System.out.println(name + " Say meow");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 5) {
            this.age = age;
        }
    }
}
