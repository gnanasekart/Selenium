package com.org.qa.jarRunner;

import org.testng.TestNG;

import Practices.Pages.CreateLeadPage;

public class JavaRunner {
	
	static TestNG testng;
	public static void main(String[] args) {
		
		testng = new TestNG();
		testng.setTestClasses(new Class[] {CreateLeadPage.class});

	}

}
