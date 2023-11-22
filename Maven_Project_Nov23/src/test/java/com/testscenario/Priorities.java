package com.testscenario;

import org.testng.annotations.Test;

public class Priorities {
  @Test(priority = 1)
  public void first() {
	  System.out.println("@first");
  }
  @Test(priority = 2)
  public void second() {
	  System.out.println("@second");
  }
  @Test(priority =3)
  public void third() {
	  System.out.println("@third");
  }
  @Test(priority =4)
  public void fourth() {
	  System.out.println("@fourth");
  }
}
