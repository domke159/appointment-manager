//////////////////////////////////////////////////////////////////////////////////////
// Author:           Dominykas Mickevicius
// Changes made to the code that are different from the UML diagram:
// added setModuleList() method
//////////////////////////////////////////////////////////////////////////////////////

package com.example.tddCoursework.productionCode;

import java.util.List;

public class Student extends Person {
	
  private String studentID;
  private String courseTitle;
  private String enrollmentDate;
  private List<Module> moduleList;
	
  // constructor for Student class
  public Student(String name, int age, String studentID, String courseTitle, String enrollmentDate, String email) {
    super(name, age);
    this.studentID = studentID;
    setCourseTitle(courseTitle);
    setEnrollmentDate(enrollmentDate);
    setEmail(email);
  }

  // get and set methods
  public String getStudentID() { 
    return this.studentID; 
  }
 
  public void setCourseTitle(String courseTitle) { 
    this.courseTitle = courseTitle; 
  }
	  
  public String getCourseTitle() { 
    return this.courseTitle; 
  }

  public void setEnrollmentDate(String enrollmentDate) {  
    this.enrollmentDate = enrollmentDate; 
  }
	  
  public String getEnrollmentDate() { 
    return this.enrollmentDate; 
  }
	
  public void setModuleList(List<Module> moduleList) {
    this.moduleList = moduleList;
  }
	  
  public List<Module> getModuleList() { 
    return this.moduleList; 
  }
	
  // override toString to print details about a student
  @Override
  public String toString() { 
    return "Name: " + getName() + " | " + "Age: " + getAge() + " | " + "Student ID: " + this.studentID + " | " + 
           "Course Title: " + this.courseTitle + " | " + "Enrollment Date: " + this.enrollmentDate + " | " + 
           "Address: " + getAddress() + " | " + "E-mail: " + getEmail(); 
  } 	
}