///////////////////////////////////////////////////////////////////////////////
// Author:           Dominykas Mickevicius
// Changes made to the code that are different from the UML diagram:
// None
///////////////////////////////////////////////////////////////////////////////

package com.example.tddCoursework.productionCode;


public class Person {
	
  private String name;
  private int age;
  private String address;
  private String email;
	
  // constructor for Person class
  public Person(String name, int age) {
    setName(name);
    setAge(age);
  }
	
  // get and set methods
  public void setName(String name) {
    this.name = name;
  }
		  
  public String getName() { 
    return this.name; 
  }
	
  public void setAge(int age) { 
    this.age = age;
  }
	
  public int getAge() { 
    return this.age; 
  }
	
  public void setAddress(String address) { 	 
    this.address = address;
  }
	
  public String getAddress() { 
    if (this.address == null) {
      return "*This person has not specified his address*";
    }
    return this.address; 
  }
	 
  public void setEmail(String email) { 
    this.email = email; 
  }
	
  public String getEmail() { 
    if (this.email == null) {
      return "*This person has not specified his e-mail address*";
    }
    return this.email; 
  }
	
  // override toString to print details about a person
  @Override
  public String toString() { 
    return "Name: " + getName() + " | " + "Age: " + getAge() + " | " + "Address: "
           + getAddress() + " | " + "E-mail: " + getEmail(); 
  }   
}
