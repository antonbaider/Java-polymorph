package jom.com.softserve.s2.task1;

public class Child extends Person{
    private String childIDNumber;
    public Child(int age, String name, String healthInfo, String childIDNumber) {
        super(age, name, healthInfo);
        this.childIDNumber = childIDNumber;
    }
}