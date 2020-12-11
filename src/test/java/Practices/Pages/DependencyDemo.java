package Practices.Pages;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DependencyDemo

/*{
	    @Test
	    public void groupTestOne() 
	    {
	        System.out.println("Group Test method one");
	    }
	 
	    @Test (groups = { "test-group2" })
	    public void groupTestTwo() 
	    {
	        System.out.println("Group test method two");
	    }
	 
	    @Test(groups = { "test-group" })
	    public void groupTestThree() 
	    {
	        System.out.println("Group Test method three");
	    }
	}*/

{
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { 
        	{ "data one" }, { "data two" } };
    }
 
    @Test(dataProvider = "data-provider")
    public void testMethod(String data1) {
        System.out.println("Data is: " + data1);
    }
}
	
