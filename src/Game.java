import java.util.Vector;

public class Game {
	
	Vector<gravityObject> fallingObjects = new Vector<gravityObject>(10,2);
	Vector<collisionObject> collidingObjects = new Vector<collisionObject>(10,2);
	Ball theBall = new Ball();	
	Block topBlock = new Block();
	Block theBlock = new Block();
	Game()
	{
		fallingObjects.add(theBall);
		collidingObjects.add(theBall);
		collidingObjects.add(theBlock);
		topBlock.y = 50;
		collidingObjects.add(topBlock);
		
	}
	public void update()
	{
		for(int i = 0; i < fallingObjects.size(); i++)
		{			
			fallingObjects.elementAt(i).applyGravity();			
		}
		for(int i = 0; i < collidingObjects.size(); i++)
		{
			collidingObjects.elementAt(i).checkColliding(collidingObjects);
		}


	}
	
}
