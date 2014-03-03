import java.util.Vector;

public class Game {

	Vector<movingObject> movingList = new Vector<movingObject>(10,2);
	Vector<collisionObject> collisionList = new Vector<collisionObject>(10,2);
	Vector<collisionObject> nonStaticObjects = new Vector<collisionObject>(10,2);
	Vector<drawableObject> drawList = new Vector<drawableObject>(10,2);
	Ball theBall = new Ball();	
	Block theBlock = new Block();
	
	Game()
	{
		drawList.add(theBall);
		drawList.add(theBlock);
		movingList.add(theBall);
		collisionList.add(theBall);
		collisionList.add(theBlock);
		nonStaticObjects.add(theBall);		
	}

	public void update()
	{
		for(int i = 0; i < movingList.size(); i++)
		{			
			movingList.elementAt(i).update();		
		}
		for(int i = 0; i < nonStaticObjects.size(); i++)
		{
			nonStaticObjects.elementAt(i).checkColliding(collisionList, drawList);
		}
		for(int i = 0; i < movingList.size(); i++)
		{
			movingList.elementAt(i).move();
		}
	}

}
