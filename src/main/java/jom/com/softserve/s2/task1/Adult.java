package jom.com.softserve.s2.task1;

public class Adult extends Person{
    private String passportNumber;

    public Adult(int age, String name, String healthInfo, String passportNumber) {
        super(age, name, healthInfo);
        this.passportNumber = passportNumber;
    }


}