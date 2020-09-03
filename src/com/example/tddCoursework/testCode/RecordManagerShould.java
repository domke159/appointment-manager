///////////////////////////////////////////////////////////////////////////////
// Author:           Dominykas Mickevicius
///////////////////////////////////////////////////////////////////////////////

package com.example.tddCoursework.testCode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.tddCoursework.AbstractLoggingJUnitTest;
import com.example.tddCoursework.productionCode.Module;
import com.example.tddCoursework.productionCode.RecordManager;
import com.example.tddCoursework.productionCode.Student;

public class RecordManagerShould extends AbstractLoggingJUnitTest {
	
  private RecordManager recordManager;
  private List<Student> studentList;
  private Student student = new Student("Dominykas Mickevicius", 20, "180387629", "BSc Computer Science", 
			  		"23/09/2019", "D.Mickevicius@newcastle.ac.uk");
  Student student2 = new Student("Bob Bobson", 20, "180387630", "BSc Computer Science", 
			  	 "23/09/2019", "B.Bobson@newcastle.ac.uk");
	
  //initialise record manager and add students to the list
  @Before
  public void initialise () {
    recordManager = new RecordManager("Mike Mikeson", 38, "School of Computing", "M.Mikeson@newcastle.ac.uk");
    studentList = new ArrayList<>();
    studentList.add(student);
    studentList.add(student2);
    recordManager.setStudentList(studentList);
  }

  // test if changing the name of the student works correctly
  @Test
  public void changeStudentName() {
    String newName = "Dom Domson";
    recordManager.changeStudentName(student.getStudentID(), newName, recordManager.getStudentList());
    assertEquals("Dom Domson", student.getName());
  }
	
  // test if changing the address of the student works correctly
  @Test
  public void changeStudentAdress() {
    String newAddress = "New Address 123, London";
    recordManager.changeStudentAddress(student.getStudentID(), newAddress, recordManager.getStudentList());
    assertEquals("New Address 123, London", student.getAddress());
  }

  // test if adding a new module works correctly
  @Test
  public void addNewModule() {
    List<Module> moduleList = new ArrayList<>();
    student.setModuleList(moduleList);
    Module newModule = new Module("CSC2023", "Algorithm Design and Analysis", 20);
    recordManager.addModule(student.getStudentID(), newModule, recordManager.getStudentList());
    assertSame(newModule, student.getModuleList().get(0));
  }
	
  // test to check if the module with the same code does not get added to the module list
  @Test
  public void notAddNewModuleWithTheSameCode() {
    List<Module> moduleList = new ArrayList<>();
    student.setModuleList(moduleList);
    Module newModule = new Module("CSC2023", "Algorithm Design and Analysis", 20);
    Module newModule2 = new Module("CSC2023", "Algorithm Design and Analysis", 20);
    recordManager.addModule(student.getStudentID(), newModule, recordManager.getStudentList());
    recordManager.addModule(student.getStudentID(), newModule2, recordManager.getStudentList());
    // assert module was added by checking the size of the module list
    assertEquals(1, student.getModuleList().size());
    // assert that module was added to the module list
    assertSame(newModule, student.getModuleList().get(0));
    // assert that module with the same code was not added to the module list
    assertNotSame(newModule2, student.getModuleList().get(0));
  }
	
  // test if calculating the average mark works correctly
  @Test
  public void calculateAverageMark() {
    List<Module> moduleList = new ArrayList<>();
    student.setModuleList(moduleList);
    // initialise new modules and set their marks (except module2)
    Module module = new Module("CSC2023", "Algorithm Design and Analysis", 20);
    recordManager.addModule(student.getStudentID(), module, recordManager.getStudentList());
    module.setModuleMark(76);
    Module module2 = new Module("CSC2021", "Software Engineering", 10);
    recordManager.addModule(student.getStudentID(), module2, recordManager.getStudentList());
    Module module3 = new Module("CSC2022", "Software Engineering Team Project", 10);
    recordManager.addModule(student.getStudentID(), module3, recordManager.getStudentList());
    module3.setModuleMark(90);
    Module module4 = new Module("CSC2025", "Operating Systems", 20);
    recordManager.addModule(student.getStudentID(), module4, recordManager.getStudentList());
    module4.setModuleMark(71);
    double avgMark = recordManager.calculateAverageMark(student.getStudentID(), recordManager.getStudentList());
    // assert the average mark without specifying the module mark for module2
    assertEquals(79.0, avgMark, 0.01);
    // set module mark for module2
    module2.setModuleMark(88);
    avgMark = recordManager.calculateAverageMark(student.getStudentID(), recordManager.getStudentList());
    // assert the average mark after specifying the module mark for module2
    assertEquals(81.25, avgMark, 0.01);
  }
}
