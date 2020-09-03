///////////////////////////////////////////////////////////////////////////////
// Author:           Dominykas Mickevicius
// Changes made to the code that are different from the UML diagram:
// None
///////////////////////////////////////////////////////////////////////////////

package com.example.tddCoursework.productionCode;

public class Module {
	
  private String code;
  private String title;
  private int mark;
  private int credits;
  
  // constructor for module class
  public Module(String code, String title, int credits) {
    setModuleCode(code);
    setModuleTitle(title);
    setModuleCredits(credits);
  }
	
  // get and set methods
  public void setModuleCode(String code) { 
    this.code = code; 
  }
  
  public String getModuleCode() { 
    return this.code; 
  }

  public void setModuleTitle(String title) { 
    this.title = title;	
  }
  
  public String getModuleTitle() { 
    return this.title; 
  }

  public void setModuleMark(int mark) { 
    this.mark = mark;
  }

  public int getModuleMark() { 
    return this.mark; 
  }
  
  public void setModuleCredits(int credits) { 
    this.credits = credits;
  }

  public int getModuleCredits() { 
    return this.credits; 
  }
	
  // override toString to print details about a module
  @Override
  public String toString() { 
    if (mark == 0) {
      return "Module Code: " + getModuleCode() + " | " + "Module Title: " + getModuleTitle() + 
             " | " + "Module Credits: " + getModuleCredits() + " | " + "Module Mark: *0 - Not yet known*"; 
    }
    return "Module Code: " + getModuleCode() + " | " + "Module Title: " + getModuleTitle() + 
           " | " + "Module Credits: " + getModuleCredits() + " | " + "Module Mark: " + getModuleMark(); 
  } 
}
