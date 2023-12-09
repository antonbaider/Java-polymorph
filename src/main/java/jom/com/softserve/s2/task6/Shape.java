package jom.com.softserve.s2.task6;

public abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getCircleArea() {
        //Code
        return 0.0;
    }

    public double getRectangleArea() {
        //Code
        return 0.0;
    }

    public double getArea() {
        if (getName().equals("Circle")) {
            return getCircleArea();
        } else {
            return getRectangleArea();
        }
        //Code
    }
}
