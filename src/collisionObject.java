import java.util.Vector;

public class collisionObject {
	int x = 0;
	float y = 0;
	float yVelocity = 0;
	float yAcceleration = 0;
	float xVelocity = 0;
	float xAcceleration = 0;
	int boundingWidth = 0;
	int boundingHeight = 0;

	public void checkColliding(Vector<collisionObject> collisionList, Vector<drawableObject> drawList) {
		for(int i = 0; i < collisionList.size(); i++)
		{
			if(collisionList.elementAt(i) != this)
			{
				int objectOneFinalX = (int)(this.x + this.xVelocity);
				int objectOneFinalY = (int)(this.y + this.yVelocity);
				int objectOneCurrentY = (int)this.y;
				int objectOneCurrentX = (int)this.x;
				
				int objectTwoCurrentX = (int)collisionList.elementAt(i).x;
				int objectTwoCurrentY = (int)collisionList.elementAt(i).y;
				int objectTwoFinalX = (int)(collisionList.elementAt(i).x + collisionList.elementAt(i).xVelocity);
				int objectTwoFinalY = (int)(collisionList.elementAt(i).y + collisionList.elementAt(i).yVelocity);
				
				   
				
				// horizontal collision is where the Ys are already colliding, and the xVelocity causes a collision.
				boolean horizontalCollision = (Math.abs(objectOneFinalX - objectTwoFinalX) * 2 < (this.boundingWidth + collisionList.elementAt(i).boundingWidth)) && 
						(Math.abs(objectOneCurrentY - objectTwoCurrentY) * 2 < (this.boundingHeight + collisionList.elementAt(i).boundingHeight));
				boolean verticalCollision = (Math.abs(objectOneCurrentX - objectTwoCurrentX) * 2 < (this.boundingWidth + collisionList.elementAt(i).boundingWidth)) && 
						(Math.abs(objectOneFinalY - objectTwoFinalY) * 2 < (this.boundingHeight + collisionList.elementAt(i).boundingHeight));
				if(this instanceof Ball)
				{
					if(horizontalCollision)
					{				
							if(collisionList.elementAt(i) instanceof Block)
							{
								collisionList.remove(i);
								drawList.remove(i);
							}
							else
							{
								if(this.xVelocity > 0)
								{
									this.x = collisionList.elementAt(i).x - (collisionList.elementAt(i).boundingWidth/2) - (this.boundingWidth/2);
								}
								else
								{
									this.x = collisionList.elementAt(i).x + (collisionList.elementAt(i).boundingWidth/2) + (this.boundingWidth/2);
								}	
								this.xVelocity = 0;
							}
					}
					if(verticalCollision)
					{
							if(collisionList.elementAt(i) instanceof Block)
							{
								collisionList.remove(i);
								drawList.remove(i);
							}
							else
							{
								if(this.yVelocity > 0)
								{
									this.y = collisionList.elementAt(i).y - (collisionList.elementAt(i).boundingHeight/2) - (this.boundingHeight/2);
								}
								else
								{
									this.y = collisionList.elementAt(i).y + (collisionList.elementAt(i).boundingHeight/2) + (this.boundingHeight/2);
								}								 
								this.yVelocity = 0.0f;
							}
					}	
				}
			}				
		}
	}
}

	