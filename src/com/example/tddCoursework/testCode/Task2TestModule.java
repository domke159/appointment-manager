///////////////////////////////////////////////////////////////////////////////
// Author:           Dominykas Mickevicius
///////////////////////////////////////////////////////////////////////////////

package com.example.tddCoursework.testCode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.tddCoursework.productionCode.Module;

public class Task2TestModule {

  private Module module;
	
  // initialise new Module before the tests
  @Before
  public void initialise () {
    module = new Module("CSC2021", "Software Engineering", 20);
  }

  // assert class
  @Test
  public void testClass() {
    assertEquals(Module.class, module.getClass());
  }
	
  // test methods for getters and setters
  @Test
  public void testGetModuleCodeAndSetModuleCode() {
    assertEquals("CSC2021", module.getModuleCode());
    module.setModuleCode("CSC2022");
    assertEquals("CSC2022", module.getModuleCode());
  }
	
  @Test
  public void testGetModuleTitleAndSetModuleTitle() {
    assertEquals("Software Engineering", module.getModuleTitle());
    module.setModuleTitle("Software Engineering Team Project");
    assertEquals("Software Engineering Team Project", module.getModuleTitle());
  }
	
  @Test
  public void testGetModuleMarkAndSetModuleMark() {
    assertEquals(0, module.getModuleMark());
    module.setModuleMark(81);
    assertEquals(81, module.getModuleMark());
  }
	
  @Test
  public void testGetModuleCreditsAndSetModuleCredits() {
    assertEquals(20, module.getModuleCredits());
    module.setModuleCredits(10);
    assertEquals(10, module.getModuleCredits());
  }
	
  // toString method testing
  @Test
  public void testToString() {
    String expected = "Module Code: CSC2021 | Module Title: Software Engineering | Module Credits: 20 | "
		       + "Module Mark: *0 - Not yet known*"; 
    assertEquals(expected, module.toString());
        
    module.setModuleMark(81);
    expected = "Module Code: CSC2021 | Module Title: Software Engineering | Module Credits: 20 | "
	       + "Module Mark: 81"; 
    assertEquals(expected, module.toString());
  }
	
  // test if two Module objects are the same
  @Test
  public void testSameObjects() {
    Module module2 = new Module("CSC2022", "Software Engineering Team Project", 10);
    assertNotSame(module, module2);
    assertSame(module, module);
  }
}
