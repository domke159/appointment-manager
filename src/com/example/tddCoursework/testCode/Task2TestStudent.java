///////////////////////////////////////////////////////////////////////////////
// Author:           Dominykas Mickevicius
///////////////////////////////////////////////////////////////////////////////

package com.example.tddCoursework.testCode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.tddCoursework.productionCode.Module;
import com.example.tddCoursework.productionCode.Student;

public class Task2TestStudent {

  private Student student;
  private List<Module> moduleList;
  private Module module = new Module("CSC2021", "Software Engineering", 20);
  private Module module2 = new Module("CSC2022", "Software Engineering Team Project", 10);
	
  // initialise new Student and add modules to student's module list before the tests
  @Before
  public void initialise () {
    student = new Student("Dominykas Mickevicius", 20, "180387629", "BSc Computer Science", 
			  "23/09/2019", "D.Mickevicius@newcastle.ac.uk");
    moduleList = new ArrayList<>();
    moduleList.add(module);
    moduleList.add(module2);
    student.setModuleList(moduleList);
  }
	
  // assert class
  @Test
  public void testClass() {
    assertEquals(Student.class, student.getClass());
  }
	
  // test methods for getters and setters
  @Test
  public void testGetStudentID() {
    assertEquals("180387629", student.getStudentID());
  }
	
  @Test
  public void testGetCourseTitleAndSetCourseTitle() {
    assertEquals("BSc Computer Science", student.getCourseTitle());
    student.setCourseTitle("BSc Computer Science (Game Engineering)");
    assertEquals("BSc Computer Science (Game Engineering)", student.getCourseTitle());
  }
	
  @Test
  public void testGetEnrollmentDateAndSetEnrollmentDate() {
    assertEquals("23/09/2019", student.getEnrollmentDate());
    student.setEnrollmentDate("23/09/2021");
    assertEquals("23/09/2021", student.getEnrollmentDate());
  }
	
  @Test
  public void testGetModuleListAndSetModuleList() {
    assertEquals(moduleList, student.getModuleList());
    List<Module> moduleList2 = new ArrayList<>();
    student.setModuleList(moduleList2);
    assertEquals(moduleList2, student.getModuleList());
  }
	
  // test if adding to list works correctly
  @Test
  public void testAddToList() {
    Module moduleToAdd = new Module("CSC2025", "Operating Systems", 20);
    assertEquals(2, student.getModuleList().size());
    student.getModuleList().add(moduleToAdd);
    assertEquals(3, student.getModuleList().size());
    assertSame(student.getModuleList().get(2), moduleToAdd);
  }
	
  // test if deleting from list works correctly
  @Test
  public void testDeleteFromList() {
    assertEquals(2, student.getModuleList().size());
    student.getModuleList().remove(1);
    assertEquals(1, student.getModuleList().size());
    assertSame(student.getModuleList().get(0), module);
  }
	
  // toString method testing
  @Test
  public void testToString() {
    String expected = "Name: Dominykas Mickevicius | Age: 20 | Student ID: 180387629 | Course Title: BSc Computer Science | "
		      + "Enrollment Date: 23/09/2019 | Address: *This person has not specified his address* | "
		      + "E-mail: D.Mickevicius@newcastle.ac.uk";
    assertEquals(expected, student.toString());
        
    student.setAddress("Someroad 125, Newcastle upon Tyne");
    expected = "Name: Dominykas Mickevicius | Age: 20 | Student ID: 180387629 | Course Title: BSc Computer Science | "
	       + "Enrollment Date: 23/09/2019 | Address: Someroad 125, Newcastle upon Tyne | "
	       + "E-mail: D.Mickevicius@newcastle.ac.uk";
    student.setAddress("Someroad 125, Newcastle upon Tyne");
  }
	
  // test if two Student objects are the same
  @Test
  public void testSameObjects() {
    Student student2 = new Student("Bob Bobson", 20, "180387630", "BSc Computer Science", 
				   "23/09/2019", "B.Bobson@newcastle.ac.uk");
    assertNotSame(student, student2);
    assertSame(student, student);
  }
}
