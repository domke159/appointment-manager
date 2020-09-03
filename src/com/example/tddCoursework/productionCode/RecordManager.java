///////////////////////////////////////////////////////////////////////////////
// Author:           Dominykas Mickevicius
// Changes made to the code that are different from the UML diagram:
// added setStudentList() method
///////////////////////////////////////////////////////////////////////////////

package com.example.tddCoursework.productionCode;

import java.util.ArrayList;
import java.util.List;

public class RecordManager extends Person {
	
  private String department;
  private List<Student> studentList;
	
  // constructor for RecordManager class
  public RecordManager(String name, int age, String department, String email) {
    super(name, age);
    setDepartment(department);
    setEmail(email);
  }
	
  // get and set methods
  public void setDepartment(String department) {
    this.department = department; 
  }
	
  public String getDepartment() {
    return this.department;
  }
	
  public void setStudentList(List<Student> studentList) {
    this.studentList = studentList;
  }
	
  public List<Student> getStudentList() {
    return this.studentList;
  }
	
  // method to change find students with the same name
  public List<Student> searchStudents(String studentName, List<Student> studentList) {
    List<Student> matchingStudents = new ArrayList<>();
    for (Student s: studentList) {
      if (s.getName().equals(studentName)) {
        matchingStudents.add(s);
      }
    }
    return matchingStudents;
  }
	
  // method to change student's name
  public void changeStudentName(String studentID, String newName, List<Student> studentList) {
    for (Student s: studentList) {
      if (s.getStudentID().equals(studentID)) {
        s.setName(newName);
      }
    }
  }
	
  // method to change student's address
  public void changeStudentAddress(String studentID, String newAddress, List<Student> studentList) {
    for (Student s: studentList) {
      if (s.getStudentID().equals(studentID)) {
        s.setAddress(newAddress);
      }
    }
  }
	
  // method to add a new module
  public void addModule(String studentID, Module newModule, List<Student> studentList) {
    for (Student s: studentList) {
      if (s.getStudentID().equals(studentID)) {
        for (Module m: s.getModuleList()) {
          if (m.getModuleCode().equalsIgnoreCase(newModule.getModuleCode())) {
            return;
          }
        }
        s.getModuleList().add(newModule);
      }
    }
  }
	
  // method to calculate average mark
  public double calculateAverageMark(String studentID, List<Student> studentList) {
    double avgMark = 0;
    double moduleCount = 0;
    for (Student s: studentList) {
      if (s.getStudentID().equals(studentID)) {
        for (Module m: s.getModuleList()) {
          if (m.getModuleMark() != 0) {
            avgMark += m.getModuleMark();
            moduleCount++;
          }
        }
        avgMark /= moduleCount; 
      }
    }
    return avgMark;
  }
	
  // override toString to print details about a record manager
  @Override
  public String toString() { 
    return "Name: " + getName() + " | " + "Age: " + getAge() + " | " + "Department: " + this.department + " | " + 
           "Address: " + getAddress() + " | " + "E-mail: " + getEmail(); 
  } 
}
