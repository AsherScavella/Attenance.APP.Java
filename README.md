# **📋 AttendanceApp**
A simple Java console program used to manage and track student attendance for a course section.

---

## **Table of Contents**

- [Authors](#-authors)
- [Project Overview](#-project-overview)
- [Project Structure](#-project-structure)
- [Input Validation Rules](#-input-validation-rules)
- [Concepts Demonstrated](#-concepts-demonstrated)
- [Example Run/Testing](#-example-runtesting)

---

## **👥 Authors**

- **Asher Scavella**

🔗 **Repository:**
https://github.com/AsherScavella/Attenance.APP.Java


---

## **📌 Project Overview**

This project is a Java attendance tracking application that allows a user to manage and record student attendance for a course section. The program keeps track of students and records whether they were on time, late, excused, or unexcused.

The application is built using object-oriented programming, where different classes work together to manage the system. The AttendanceApp class runs the program and controls the menu system. The Course class manages the list of students in the course, and the Student class stores each student's attendance information.

The goal of this project is to practice using Java concepts such as classes, objects, ArrayLists, methods, and exception handling while building a program that organizes and reports attendance data.

This program can generate attendance summaries and detailed reports, which makes it easier to see the attendance status of students in the course.

---

## **🏗 Project Structure**

### Student.java

The Student class represents an individual student and their attendance record.

Each student has:

- A seat number  
- A student name  
- Attendance counters for:
  - On Time
  - Late
  - Excused
  - Unexcused

The Student class updates attendance counts and returns attendance information when the Course class generates reports.
### **Course.java**

### Course.java

The Course class represents a course section that contains multiple students.

This class manages the list of students in the course and keeps track of their attendance records. It stores the course name and uses an ArrayList to store Student objects.

The Course class can:

- Add students to the course
- Find students by seat number
- Calculate attendance totals for the course
- Display attendance summaries
- Generate detailed attendance reports for all students

The Course class works together with the Student class to collect and display attendance information for the entire course.

### **AttendanceApp.java**
The AttendanceApp class is the main program that runs the attendance system.

This class controls the flow of the program and interacts with the user through a menu system. It allows the user to manage students and record their attendance for a course section.

The AttendanceApp class can:

- Add students to the course
- Record attendance for students
- Display attendance summaries
- Display detailed attendance reports

This class works together with the Course and Student classes to manage and update attendance information in the system.


---

## **🛡 Input Validation Rules**

- Seat numbers must be valid
- Course name cannot be blank
- Students cannot have duplicate seats

---

## **💡 Concepts Demonstrated**

- Object-Oriented Programming
- Classes and Objects
- Constructor Overloading
- Encapsulation
- ArrayLists
- Exception Handling
- Input validation

---

## **🧪 Example Run/Testing**

Example program output:
