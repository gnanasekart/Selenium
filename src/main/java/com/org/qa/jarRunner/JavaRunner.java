package com.org.qa.jarRunner;

import org.testng.TestNG;

import com.org.qa.testcases.CreateLeadPage;



public class JavaRunner {
	
	static TestNG testng;
	public static void main(String[] args) {
		
		testng = new TestNG();
		testng.setTestClasses(new Class[] {CreateLeadPage.class});

	}

}
