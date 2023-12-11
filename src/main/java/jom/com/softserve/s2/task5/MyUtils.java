package jom.com.softserve.s2.task5;

import java.util.List;

abstract class Shape {
    abstract double getPerimeter();
}

class Square extends Shape {
    private final double width;

    public Square(double width) {
        this.width = width;
    }

    public double getPerimeter() {
        return 4 * width;
    }
}

class Rectang extends Shape {
    private final double height;
    private final double wigth;

    public Rectang(double height, double wigth) {
        this.height = height;
        this.wigth = wigth;
    }

    public double getPerimeter() {
        return 2 * (height + wigth);
    }
}

public class MyUtils {
    private double sum = 0;

    public double sumPerimeter(List<?> figures) {
        for (Object fig : figures) {
            if (fig instanceof Shape) {
                sum += ((Shape) fig).getPerimeter();
            } else {
                return 0;
            }
        }
        return sum;
    }
}
