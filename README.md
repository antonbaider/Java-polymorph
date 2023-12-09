## Task 4

Create classes Employee (fields String name, int experience and BigDecimal basePayment) 
and Manager (field double coefficient) 
with methods which return the general working experience and payment for work done.

---
A getter methods of class Employee return value of all fields: 
getName(), getExperience() and getPayment().

---
Classes Manager is derived from class Employee and override getPayment() method 
to return multiplication of a coefficient and base payment.

---
Create a largestEmployees() method of the MyUtils class 
to return a List of unique employees with maximal working experience 
and payment without duplicate objects.

* The original list must be unchanged.

---
For example, for a given list

---
* [Employee [name=Ivan, experience=10, basePayment=3000.00], 
* Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],  
* Employee [name=Stepan, experience=8, basePayment=4000.00], 
* Employee [name=Andriy, experience=7, basePayment=3500.00], 
* Employee [name=Ihor, experience=5, basePayment=4500.00], 
* Manager [name=Vasyl, experience=8, basePayment=2000.00, coefficient=2.0]]

---
you should get

---
* [Employee [name=Ivan, experience=10, basePayment=3000.00], 
* Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5], 
* Employee [name=Ihor, experience=5, basePayment=4500.00]].

---
## When you will paste code to Moodle, leave only one public class 'MyUtils'
