
/*
 * Class: CMSC203 
 * Instructor:Farnaz Eivazi
 * Description: (Property creates a property using arguments of name, city, rent amout, owner, and it 
 * 				includes arguments to make a plot.)
 * Due: 11/06/2022
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Duga Gang
*/
public class Property extends Object{
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	public Property() 
	{
		propertyName = "";
		city = "";
		owner = "";
		plot = new Plot();
	}
	public Property(String propertyName, String city, double rentAmount, String owner) 
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount =  rentAmount;
		this.owner = owner;
		plot = new Plot();
	}
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) 
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x, y, width, depth);
	}
	public Property(Property otherProperty) 
	{
		propertyName = otherProperty.propertyName;
		city = otherProperty.city;
		rentAmount = otherProperty.rentAmount;
		owner = otherProperty.owner;
		plot = otherProperty.plot;
	}
	public Plot getPlot() 
	{
		return plot;
	}
	public String getPropertyName() 
	{
		return propertyName;
	}
	public String getCity() 
	{
		return city;
	}
	public double getRentAmount() 
	{
		return rentAmount;
	}
	public String getOwner() 
	{
		return owner;
	}
	public String toString() 
	{
		return propertyName + "," + city + "," + owner + "," + rentAmount;
	}

}
