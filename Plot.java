/*
 * Class: CMSC203 
 * Instructor:Farnaz Eivazi
 * Description: (Plot takes arguments for x and y coordinates and width and depth and it creates a box on a plane. 
 * 				The class also checks if the plot overlaps or encompasses any other plots.)
 * Due: 11/06/2022
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Duga Gang
*/

public class Plot extends Object{
	private int x;
	private int y;
	private int width;
	private int depth;
	public Plot() 
	{
		width = 1;
		depth = 1;
		
	}
	public Plot(int x, int y, int width, int depth) 
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
		
	}
	public Plot(Plot otherPlot) 
	{
		x = otherPlot.x;
		y = otherPlot.y;
		width = otherPlot.width;
		depth = otherPlot.depth;
	}
	public boolean overlaps(Plot plot) 
	{
		boolean status = true;
		if (x + width <= plot.x) //left and right sides of rectangle
		{
			status = false;
		}
		if (x >= plot.x + plot.width) //right and left sides
		{
			status = false;
		}
		if (y + depth <= plot.y) //top and bottom sides
		{
			status = false;
		}
		if (y >= plot.y + plot.depth) //bottom and top sides 
		{
			status = false;
		}
		return status;
	}
	public boolean encompasses(Plot plot) 
	{
		boolean status = false;
		if (plot.x >= x && plot.x + plot.width <= x + width && plot.y >= y && plot.y + plot.depth <= y + depth) 
		{
			status = true;
		}
		return status;
	}
	public void setX(int x) 
	{
		this.x = x;
	}
	public void setY(int y) 
	{
		this.y = y;
	}
	public void setWidth(int width) 
	{
		this.width = width;
	}
	public void setDepth(int depth) 
	{
		this.depth = depth;
	}
	public int getX() 
	{
		return x;
	}
	public int getY() 
	{
		return y;
	}
	public int getWidth() 
	{
		return width;
	}
	public int getDepth() 
	{
		return depth;
	}
	public String toString() 
	{
		return x + "," + y + "," + width + "," + depth;
	}
}
