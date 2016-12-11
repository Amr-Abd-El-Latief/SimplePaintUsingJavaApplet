
class Line{
	
	private	int startX;
	private	int startY;
	private	int currentX;
	private	int currentY;
	public Line()
	{
		startX=0;
		startY=0;
		currentX=0;
		currentY=0;

	}



	public Line(int sX,int sY,int cX,int cY)
	{
		startX=sX;
		startY=sY;
		currentX=cX;
		currentY=cY;

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




}