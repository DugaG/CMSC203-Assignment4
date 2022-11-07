
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PlotTestStudent {
	private Plot plot1, plot5, plot6, plot7;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(2, 2, 6, 6);
		plot5 = new Plot(3, 4, 4, 3);
		plot6 = new Plot(4, 5, 1, 1);
		plot7 = new Plot(9, 9, 2, 2);
		
	}

	@After
	public void tearDown() throws Exception {
		plot1 = plot5 = plot6 = null;
	}

	@Test
	public void testOverlaps() {
		assertTrue(plot1.overlaps(plot5)); // plot5 is entirely inside plot1
		assertFalse(plot7.overlaps(plot1)); // these plot do not overlap
	}
	
	@Test
	public void testToString() {
		assertEquals("3,4,4,3",plot5.toString());	
	}
	
	@Test
	public void testEncompasses() 
	{
		assertTrue(plot5.encompasses(plot6));
		assertFalse(plot6.encompasses(plot5));
	}
	
	@Test
	public void testGetWidth() 
	{
		assertEquals(plot1.getWidth(), 6);
	}
	
	@Test
	public void testGetDepth() 
	{
		assertEquals(plot5.getDepth(), 3);
	}

}
