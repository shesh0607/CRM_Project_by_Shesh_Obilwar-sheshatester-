package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx {
	@Test(dataProvider="dataProvider")
	public void bookTickets(String src,String des)
	{
		System.out.println("Book ticket from" +src+ " to" +des);
	}
	
	@DataProvider
	public Object[][] dataProvider()
	{
		Object [][] obj=new Object[3][2];
		obj[0][0]="Banglore";
		obj[0][1]="goa";
		
		obj[1][0]="Banglore";
		obj[1][1]="mysuru";
		
		obj[2][0]="Banglore";
		obj[2][1]="Hyd";
		return obj;
		
	}
	
	

}
