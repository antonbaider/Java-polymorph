package jom.com.softserve.s2.task1;

public class Person{
    private int age;
    private String name;
    private String healthInfo;

    public Person(int age, String name, String healthInfo) {
        this.age = age;
        this.name = name;
        this.healthInfo = healthInfo;
    }

    private String getHealthStatus() {
        return name + " " + healthInfo;
    }
}