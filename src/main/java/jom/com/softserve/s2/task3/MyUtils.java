package jom.com.softserve.s2.task3;


import java.util.*;
import java.util.stream.Collectors;


class Person {
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Student extends Person {
    private String studyPlace;
    private int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }
}

class Worker extends Person {
    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
}

public class MyUtils {

    public List<Person> maxDuration(List<Person> persons) {

        int maxStudyYears = -1;
        int maxExperienceYears = -1;

        for (Person person : persons) {
            if (person instanceof Student) {
                int studyYears = ((Student) person).getStudyYears();
                maxStudyYears = Math.max(maxStudyYears, studyYears);
            } else if (person instanceof Worker) {
                int experienceYears = ((Worker) person).getExperienceYears();
                maxExperienceYears = Math.max(maxExperienceYears, experienceYears);
            }
        }

        List<Person> result = new ArrayList<>();

        for (Person person : persons) {
            if ((person instanceof Student && ((Student) person).getStudyYears() == maxStudyYears)
                    || (person instanceof Worker && ((Worker) person).getExperienceYears() == maxExperienceYears)) {
                result.add(person);
            }
        }

        return result;
    }
}

