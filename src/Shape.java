
import java.awt.Color; 
import java.awt.Point; 
import java.util.Vector;
import java.lang.Math.*; 
class Shape{
	
	private	int startX;
	private	int startY;
	private	int currentX;
	private	int currentY;
	private Color c;
	int shapeType;
	Point currentPoint;
	private boolean isFilled=false;

public	Vector<Point> pointVector;
	public Shape()
	{
		startX=0;
		startY=0;
		currentX=0;
		currentY=0;
		c=Color.black;
		shapeType=0;
		isFilled=false;
		pointVector=new Vector<Point>();


	}

	public Shape(int sX,int sY,Color cU,int sT)
	{
		startX=sX;
		startY=sY;
		currentX=sX;
		currentY=sY;
		c=cU;
		shapeType=sT;

		pointVector=new Vector<Point>();

	}



	public Shape(int sX,int sY,int cX,int cY,Color cU,int sT)
	{
		startX=sX;
		startY=sY;
		currentX=cX;
		currentY=cY;
		c=cU;
		shapeType=sT;

		pointVector=new Vector<Point>();



	}


	public void setStartX(int x)
	{
		startX=x;
	}

	public void setStartY(int y)
	{
		startY=y;
	}
	public void setCurrentX(int x)
	{
		currentX=x;
	}
	public void setCurrentY(int y)
	{
		currentY=y;
	}
	public void setColor(Color uc)
	{
		c=uc;
	}
	public void setShapeType(int sT)
	{
		shapeType=sT;
	}



	public int getStartX()
	{
		return startX;

	}	

	public int getStartY()
	{
		return startY;

	}	
	public int getCurrentX()
	{
		return currentX;

	}	
	public int getCurrentY()
	{
		return currentY;

	}	

	public Color getColor()
	{
		return c;

	}	

	public int getShapeType()
	{
		return shapeType;
	}
	public void setIsFilled(boolean iFilled)
	{
		isFilled=iFilled;

	}

	public boolean getIsFilled()
	{
		return isFilled;

	}

//  other Functions 

	public int getMinX()
	{
		return Math.min(startX,currentX);

	}	

	public int getMinY()
	{
		return Math.min(startY,currentY);

	}	



}