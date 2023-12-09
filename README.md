## Task 3
* Create next types: Person (field String name), 

* Student (fields String studyPlace, int studyYears) 

* and Worker (fields String workPosition, int experienceYears). 

---
Classes Student and Worker are derived from class Person. 

---
All classes have getters to return fields.

---
Create a maxDuration() method of the MyUtils class to return a list of Students 
with maximum duration of study and Workers with maximum experience.
---
For example, for a given list

* [Person [name=Ivan], 
* Student [name=Petro, studyPlace=University, studyYears=3], 
* Worker [name=Andriy, workPosition=Developer, experienceYears=12], 
* Student [name=Stepan, studyPlace=College, studyYears=4], 
* Worker [name=Ira, workPosition=Manager, experienceYears=8], 
* Student [name=Ihor, studyPlace=University, studyYears=4]]
---
you should get
* [Worker [name=Andriy, workPosition=Developer, experienceYears=12], 
* Student [name=Stepan, studyPlace=College, studyYears=4], 
* Student [name=Ihor, studyPlace=University, studyYears=4]]

---
### When you will paste code to Moodle, leave only one public class 'MyUtils'
