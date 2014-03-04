import java.util.Vector;

public class Game {

	Vector<movingObject> movingList = new Vector<movingObject>(10,2);
	Vector<collisionObject> collisionList = new Vector<collisionObject>(10,2);
	Vector<collisionObject> nonStaticObjects = new Vector<collisionObject>(10,2);
	Vector<drawableObject> drawList = new Vector<drawableObject>(10,2);
	Ball theBall = new Ball();	
	Paddle thePaddle = new Paddle();
	int blocksDestroyed = 0;
	
	Game()
	{
		drawList.add(theBall);
		drawList.add(thePaddle);
		movingList.add(theBall);
		movingList.add(thePaddle);
		collisionList.add(theBall);
		collisionList.add(thePaddle);
		nonStaticObjects.add(theBall);			
		addBlocks(collisionList, drawList);
	}

	public void update()
	{
		for(int i = 0; i < movingList.size(); i++)
		{			
			movingList.elementAt(i).update();		
		}
		for(int i = 0; i < nonStaticObjects.size(); i++)
		{
			nonStaticObjects.elementAt(i).checkColliding(collisionList, drawList, this);
		}
		for(int i = 0; i < movingList.size(); i++)
		{
			movingList.elementAt(i).move();
		}
	}
	
	public void addBlocks(Vector<collisionObject> collisionList, Vector<drawableObject> drawingList)
	{
		int yFactor = 0;
		int j = 0;
		for(int i = 0; i < 10; i++)
		{
			if((i % 5) == 0) 
			{
				yFactor ++;
				j = 0;
			}
			Block newBlock = new Block();
			newBlock.x = j * (80 + 10) + 80;
			newBlock.y = 60 * yFactor;
			collisionList.add(newBlock);
			drawingList.add(newBlock);
			j++;
		}
	}

}
