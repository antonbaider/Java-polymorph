## Task 1
Please, make refactoring of the code:

---
class Person {
String childIDNumber;    
}

---
class Child {
int age;
String healthInfo;
String name;
String getHealthStatus(){ return name +" " + healthInfo; }
}

---

class Adult {
int age;
String healthInfo;
String passportNumber;   
String name;
String getHealthStatus(){ return name +" " + healthInfo; }
}

---

We know that adult  doesn't have childIDNumber.
Child doesn't have passportNumber.
Create a public constructor in each class to initialize all their fields (make the first parameter of type int).
