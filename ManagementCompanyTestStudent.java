import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
	Property sampleProperty;
	ManagementCompany managementCo ; 
	
	@Before
	public void setUp() throws Exception {
		managementCo= new ManagementCompany("Railey", "555555555",6);
	}

	@After
	public void tearDown() throws Exception {
		managementCo=null;
	}
	
	@Test
	public void testGetPlot() 
	{
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);
		assertEquals(sampleProperty.getPlot().getX(), 2);
		assertEquals(sampleProperty.getPlot().getY(), 5);
		assertEquals(sampleProperty.getPlot().getWidth(), 2);
		assertEquals(sampleProperty.getPlot().getDepth(), 2);
	}
	
	@Test
	public void testGetMgmFeePer() 
	{
		managementCo = new ManagementCompany ("Sunsational", "1234", 15.0);		 
		
		assertEquals(1, managementCo.getMgmFeePer(), 15.0);
	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(managementCo.addProperty(sampleProperty), 0);	
	}
	
	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(managementCo.getPropertiesCount(), 1);
	}

	@Test
	public void testToString() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		managementCo.addProperty(sampleProperty);	
		String pStr = "List of the properties for " + managementCo.getName() + ", " + "taxID: " + managementCo.getTaxID() + "\n";
		pStr += "______________________________________________________\n";
		pStr += "Sunsational,Beckman,BillyBob Wilson,2613.0\n";
		pStr += "______________________________________________________\n";
		pStr += "\n Total management Fee: " + (sampleProperty.getRentAmount() * managementCo.getMgmFeePer()) / 100;
		
	}
}
