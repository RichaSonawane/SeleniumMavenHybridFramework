package com.testscenario;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Annotation1 {
  @Test
  public void abc() {
	  System.out.println("@test abc");
  }
  
  @Test
  public static void cde() {
  System.out.println("@test cde");
  }
  
    
  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeclass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterclass");
  }

}
