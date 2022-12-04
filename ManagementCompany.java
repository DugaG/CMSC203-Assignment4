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
	private int numberOfProperties = 0;
	private int count = 0;  
	
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
		int status = count;
		numberOfProperties = count + 1;
		properties[count] = new Property(name, city, rent, owner);
		count++;
			if (count == properties.length) 
			{
				status = -1;
			}
			if (properties[count-1] == null) 
			{
				status = -2;
			}
			if (count != 0) 
			{
				if (plot.encompasses(properties[count-1].getPlot()) == false) 
				{
					status = -3;
				}
				for (int i = 1; i < count; i++) 
				{
					if (properties[count-1].getPlot().overlaps(properties[i-1].getPlot()) == true) 
					{
						status = -4;
					}
				}
			}
			else 
			{
				count = status - 1;
				return count;
			}
		
		return status;
	}
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) 
	{
		int status = count;
		numberOfProperties = count + 1;
		properties[count] = new Property(name, city, rent, owner, x, y, width, depth);
		count++;
		if (count == properties.length) 
		{
			status = -1;
			return status;
		}
		if (properties[count-1] == null) 
		{
			status = -2;
			return status;
		}
		if (plot.encompasses(properties[count-1].getPlot()) == false) 
		{
			status = -3;
			return status;
		}
		if (count != 0) //skip testing the first plot because there is nothing for it to overlap
		{	
			
			for (int i = 1; i < count; i++) 
			{
				if (properties[count-1].getPlot().overlaps(properties[i-1].getPlot()) == true) 
				{
					status = -4;
					return status;
				}
			}
		}
		else 
		{
			count = status - 1;
			return count;
		}
	
	
	return status;
	
	}
	public int addProperty(Property property) 
	{
		int status = count;
		numberOfProperties = count + 1;
		properties[count] = property;
		count++;
		if (count == properties.length) 
		{
			status = -1;
			return status;
		}
		if (properties[count-1] == null) 
		{
			status = -2;
			return status;
		}
		if (plot.encompasses(properties[count-1].getPlot()) == false) 
		{
			status = -3;
			return status;
		}
		if (count != 0) 
		{
			for (int i = 1; i < count-1; i++) 
			{
				if (properties[count-1].getPlot().overlaps(properties[i-1].getPlot()))
				{
					status = -4;
					return status;
				}
			}
		}
		else 
		{
			count = status - 1;
			return count;
		}
	
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
		return numberOfProperties;
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
