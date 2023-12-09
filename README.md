## Task 6

Let the code given.
```java
public class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getCircleArea() {
        //Code
    }

    public double getRectangleArea() {
        //Code
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
```
---
Please create class Shape with abstract method to calculate area of figure and field name. 


---
Replace code in method getArea() according to principles of polymorphism i.e. 


---
Circle and Rectangle classes extends Shape class and override double getArea() method. 

---
Develop maxAreas() method of the MyUtils class to return a List with instances of maximum area.
* The original list must be unchanged.

---
For example, for a given list

---
* [Circle [radius=2.00], 
* Rectangle [height=2.00, width=3.00],
* Circle [radius=1.00], 
* Rectangle [height=3.00, width=2.00],
* Circle [radius=0.50], 
* Rectangle [height=1.00, width=2.00]]

---
you should get

---
* [Circle [radius=2.00], 
* Rectangle [height=2.00, width=3.00],
* Rectangle [height=3.00, width=2.00]]

---
## When you will paste code to Moodle, leave only one public class 'MyUtils'
