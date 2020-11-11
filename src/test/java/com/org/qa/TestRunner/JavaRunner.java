package com.org.qa.TestRunner;

import org.testng.TestNG;
import com.org.qa.testcases.CreateLeadPage;

public class JavaRunner {
	static TestNG testNg;
	public static void main(String[] args) {
		testNg = new TestNG();
		testNg.setTestClasses(new Class[] {CreateLeadPage.class});
	}
}
