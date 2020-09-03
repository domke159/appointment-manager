///////////////////////////////////////////////////////////////////////////////
// Author:           Dominykas Mickevicius
///////////////////////////////////////////////////////////////////////////////

package com.example.tddCoursework.testCode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.tddCoursework.productionCode.RecordManager;
import com.example.tddCoursework.productionCode.Student;

public class Task2TestRecordManager {

  private RecordManager recordManager;
  private List<Student> studentList;
  private Student student = new Student("Dominykas Mickevicius", 20, "180387629", "BSc Computer Science", 
			  	        "23/09/2019", "D.Mickevicius@newcastle.ac.uk");
  Student student2 = new Student("Bob Bobson", 20, "180387630", "BSc Computer Science", 
                                 "23/09/2019", "B.Bobson@newcastle.ac.uk");
	
  // initialise new RecordManager and add students to students list before the tests
  @Before
  public void initialise () {
    recordManager = new RecordManager("Mike Mikeson", 38, "School of Computing", "M.Mikeson@newcastle.ac.uk");
    studentList = new ArrayList<>();
    studentList.add(student);
    studentList.add(student2);
    recordManager.setStudentList(studentList);
  }
	
  // assert class
  @Test
  public void testClass() {
    assertEquals(RecordManager.class, recordManager.getClass());
  }
	
  // test methods for getters and setters
  @Test
  public void testGetDepartmentAndSetDepartment() {
    assertEquals("School of Computing", recordManager.getDepartment());
    recordManager.setDepartment("Faculty of Medical Sciences");
    assertEquals("Faculty of Medical Sciences", recordManager.getDepartment());
  }
	
  @Test
  public void testGetStudentListAndSetStudentList() {
    assertEquals(studentList, recordManager.getStudentList());
    List<Student> studentList2 = new ArrayList<>();
    recordManager.setStudentList(studentList2);
    assertEquals(studentList2, recordManager.getStudentList());
  }
	
  // test if adding to list works correctly
  @Test
  public void testAddToList() {
    Student studentToAdd = new Student("Jack Johnson", 20, "180387620", "BSc Computer Science", 
				       "25/09/2019", "J.Johnson1@newcastle.ac.uk");
    assertEquals(2, recordManager.getStudentList().size());
    recordManager.getStudentList().add(studentToAdd);
    assertEquals(3, recordManager.getStudentList().size());
    assertSame(recordManager.getStudentList().get(2), studentToAdd);
  }
	
  // test if deleting from list works correctly
  @Test
  public void testDeleteFromList() {
    assertEquals(2, recordManager.getStudentList().size());
    recordManager.getStudentList().remove(1);
    assertEquals(1, recordManager.getStudentList().size());
    assertSame(recordManager.getStudentList().get(0), student);
  }
	
  // test if searching for students with same names works correctly
  @Test
  public void testSearchStudents() {
    //initialise a list with students that have same name and create new students
    List<Student> sameNameStudents = new ArrayList<>();
    Student student1 = new Student("John Johnson", 20, "180387626", "BSc Computer Science", 
				   "23/09/2019", "J.Johnson1@newcastle.ac.uk");
    Student student2 = new Student("John Johnson", 20, "180387623", "BSc Computer Science", 
				   "23/09/2019", "J.Johnson2@newcastle.ac.uk");
    Student student3 = new Student("John Johnson", 20, "180387621", "BSc Computer Science", 
				   "23/09/2019", "J.Johnson3@newcastle.ac.uk");
		
    // assert that lists are not the same
    assertNotSame(sameNameStudents, recordManager.getStudentList());
    // add students to the sameNameStudents list
    sameNameStudents.add(student1);
    sameNameStudents.add(student2);
    sameNameStudents.add(student3);
    // add students to the studentList
    recordManager.getStudentList().add(student1);
    recordManager.getStudentList().add(student2);
    recordManager.getStudentList().add(student3);
    // test if search method works correctly
    assertEquals(sameNameStudents, recordManager.searchStudents("John Johnson", recordManager.getStudentList()));
    assertEquals(recordManager.searchStudents("John Johnson", recordManager.getStudentList()).size(), 3);
    List<Student> sameNameStudents2 = new ArrayList<>();
    Student student4 = new Student("Jack Jackson", 20, "180387626", "BSc Computer Science", 
				   "23/09/2019", "J.Johnson1@newcastle.ac.uk");
    sameNameStudents2.add(student4);
    assertNotEquals(sameNameStudents2, recordManager.searchStudents("Jack Jackson", recordManager.getStudentList()));
    assertEquals(recordManager.searchStudents("Jack Jackson", recordManager.getStudentList()).size(), 0);
    studentList.add(student4);
    assertEquals(sameNameStudents2, recordManager.searchStudents("Jack Jackson", recordManager.getStudentList()));
    assertEquals(recordManager.searchStudents("Jack Jackson", recordManager.getStudentList()).size(), 1);
  }
	
  // toString method testing
  @Test
  public void testToString() {
    String expected = "Name: Mike Mikeson | Age: 38 | Department: School of Computing | " 
		      + "Address: *This person has not specified his address* | E-mail: M.Mikeson@newcastle.ac.uk";
    assertEquals(expected, recordManager.toString());
        
    recordManager.setAddress("Someroad 121, Newcastle upon Tyne");
    expected = "Name: Mike Mikeson | Age: 38 | Department: School of Computing | " 
	       + "Address: Someroad 121, Newcastle upon Tyne | E-mail: M.Mikeson@newcastle.ac.uk";
    assertEquals(expected, recordManager.toString());
  }
	
  // test if two RecordManager objects are the same
  @Test
  public void testSameObjects() {
    RecordManager recordManager2 = new RecordManager("Jake Jakeson", 40, "School of Computing", "J.Jakeson@newcastle.ac.uk");
    assertNotSame(recordManager, recordManager2);
    assertSame(recordManager, recordManager);
  }
}
