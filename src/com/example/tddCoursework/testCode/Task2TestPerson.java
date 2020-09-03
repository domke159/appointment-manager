///////////////////////////////////////////////////////////////////////////////
// Author:           Dominykas Mickevicius
///////////////////////////////////////////////////////////////////////////////

package com.example.tddCoursework.testCode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.tddCoursework.productionCode.Person;

public class Task2TestPerson {
	
  private Person person;
	
  // initialise new Person before the tests
  @Before
  public void initialise () {
    person = new Person("John Johnson", 20);
  }

  // assert class
  @Test
  public void testClass() {
    assertEquals(Person.class, person.getClass());
  }
	
  // test methods for getters and setters
  @Test
  public void testGetNameAndSetName() {
    assertEquals("John Johnson", person.getName());
    person.setName("Jack Jackson");
    assertEquals("Jack Jackson", person.getName());
  }
	
  @Test
  public void testGetAgeAndSetAge() {
    assertEquals(20, person.getAge());
    person.setAge(15);
    assertEquals(15, person.getAge());
  }
	
  @Test
  public void testGetAddressAndSetAddress() {
    assertEquals("*This person has not specified his address*", person.getAddress());
    person.setAddress("Someroad 12, Newcastle upon Tyne");
    assertEquals("Someroad 12, Newcastle upon Tyne", person.getAddress());
  }
	
  @Test
  public void testGetEmailAndSetEmail() {
    assertEquals("*This person has not specified his e-mail address*", person.getEmail());
    person.setEmail("John123@email.com");
    assertEquals("John123@email.com", person.getEmail());
  }
	
  // toString method testing
  @Test
  public void testToString() {
    String expected = "Name: John Johnson | Age: 20 | Address: *This person has not specified his address* | "
		      + "E-mail: *This person has not specified his e-mail address*"; 
    assertEquals(expected, person.toString());
        
    person.setAddress("Someroad 12, Newcastle upon Tyne");
    person.setEmail("John123@email.com");
    expected = "Name: John Johnson | Age: 20 | Address: Someroad 12, Newcastle upon Tyne | "
	       + "E-mail: John123@email.com";
    assertEquals(expected, person.toString());
  }
	
  // test if two Person objects are the same
  @Test
  public void testSameObjects() {
    Person person2 = new Person("John Johnson", 20);
    assertNotSame(person, person2);
    assertSame(person, person);
  }
}
