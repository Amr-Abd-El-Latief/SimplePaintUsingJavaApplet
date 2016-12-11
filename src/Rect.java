
/**
 * @author Amr Abd EL Latief   amrabdellatief1@gmail.com
 * 
 * 
 */

import java.awt.Color; 



class Rect{
	
	private	int startX;
	private	int startY;
	private	int width;
	private	int height;
	private Color c;
	public Rect()
	{
		startX=0;
		startY=0;
		width=0;
		height=0;

	}

	public Rect(int sX,int sY,int cX,int cY)
	{
		startX=sX;
		startY=sY;
		width=cX;
		height=cY;

	}

	public void setStartX(int x)
	{
		startX=x;
	}

	public void setStartY(int y)
	{
		startY=y;
	}
	public void setWidth(int x)
	{
		width=x;
	}
	public void setHeight(int y)
	{
		height=y;
	}
	public void setColor(Color uc)
	{
		c=uc;
	}

	public int getStartX()
	{
		return startX;

	}	

	public int getStartY()
	{
		return startY;

	}	
	public int getWidth()
	{
		return width;

	}	
	public int getHeight()
	{
		return height;

	}	

	public Color getColor()
	{
		return c;

	}	




}