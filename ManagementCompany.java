/*
 * Class: CMSC203 
 * Instructor:Farnaz Eivazi
 * Description: (ManagementCompany uses arguments of name, tax ID, and management fee to create an management company.
 * 				It can also create a plot. In addition the class can add properties to an array, remove the last 
 * 				property in the array, and retrieve various information regarding the properties like 
 * 				which property has the highest rent.)
 * Due: 11/06/2022
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Duga Gang
*/
public class ManagementCompany extends Object{
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;
	private String name;
	private String taxID;
	private double mgmFee;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;
	private static int count = 0;
	
	public ManagementCompany() 
	{
		name = "";
		taxID ="";
		plot = new Plot(1, 1, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(String name, String taxID, double mgmFee) 
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		plot = new Plot(1, 1, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) 
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(ManagementCompany otherCompany) 
	{
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFee = otherCompany.mgmFee;
		plot = otherCompany.plot;
		properties = otherCompany.properties;
	}
	
	public int addProperty(String name, String city, double rent, String owner) 
	{
		int status = 0;
		
			properties[count] = new Property(name, city, rent, owner);
			if (count == properties.length - 1) 
			{
				status = -1;
			}
			if (properties[count] == null) 
			{
				status = -2;
			}
			if (plot.encompasses(properties[count].getPlot()) == false) 
			{
				status = -3;
			}
			if (plot.overlaps(properties[count].getPlot())) 
			{
				status = -4;
			}
			else  
			{
				status = count;
			}
		count++;
		return status;
	}
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) 
	{
		int status = count;
		
		properties[count] = new Property(name, city, rent, owner, x, y, width, depth);
		if (count == properties.length - 1) 
		{
			status = -1;
		}
		if (properties[count] == null) 
		{
			status = -2;
		}
		if (plot.encompasses(properties[count].getPlot()) == false) 
		{
			status = -3;
		}
		for (int i = 0; i < properties.length; i ++) {
			if (properties[count].getPlot().overlaps(properties[i].getPlot()) == true)  //? The first plot is automatically overlapping a plot
			{
				status = -4;
				break;
			}
			
		}
	count++;
	return status;
	
	}
	public int addProperty(Property property) 
	{
		int status = 0;
		properties[count] = property;
		if (count == properties.length - 1) 
		{
			status = -1;
		}
		if (properties[count] == null) 
		{
			status = -2;
		}
		if (plot.encompasses(properties[count].getPlot()) == false) 
		{
			status = -3;
		}
		if (properties[count].getPlot().overlaps(plot))
		{
			status = -4;
		}
		else  
		{
			status = count;
		}
	count++;
	return status;
	}
	public void removeLastProperty() 
	{
		properties[count] = null;
	}
	public boolean isPropertiesFull() 
	{
		boolean status;
		if (count == MAX_PROPERTY) 
		{
			status = true;
		}
		else status = false;
		
		return status;
	}
	public int getPropertiesCount() 
	{
		return count;
	}
	public double getTotalRent() 
	{
		double total = 0;
		for (int i = 0; i < count; i++)
		{
		total += properties[i].getRentAmount();
		}
		return total;
	}
	public Property getHighestRentPropperty() 
	{
		Property highestRentProperty = properties[0];
		double highestRent = properties[0].getRentAmount();
		for (int i = 0; i < count; i++) 
		{
			if (properties[i].getRentAmount() > highestRent)
			{
				highestRent = properties[i].getRentAmount();
				highestRentProperty = properties[i];
			}
			
		}
		
		return highestRentProperty;
	}
	public boolean isMangementFeeValid() 
	{
		boolean status = false;
		if (mgmFee >= 0 && mgmFee <= 100) 
		{
			status = true;
		}
		else status = false;
		
		return status;
	}
	public String getName() 
	{
		return name;
	}
	public String getTaxID() 
	{
		return taxID;
	}
	public Property[] getProperties() 
	{
		return properties;
	}
	public double getMgmFeePer() 
	{
		return mgmFee;
	}
	public Plot getPlot() 
	{
		return plot;
	}
	public String toString()
	{
		return "List of properties for " + name + ", taxID: " + taxID + "\n " 
				+ "________________\n" + "" + properties[0].toString() + "\n" + properties[1].toString() +
				"\n" + properties[2].toString() + "\n" + properties[3].toString() + "\n" + properties[4].toString() +
				"\n________________\n" + "total management fees: ";
		
				
	}

}
