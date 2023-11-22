package com.testscenario;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Annotation2 {
  @Test
  public void first() {
	  System.out.println("@test first");
  }
  
  @Test
  public void last() {
	  System.out.println("@test last");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("@beforemethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("@aftermethod");
  }

}
