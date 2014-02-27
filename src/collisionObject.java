import java.util.Vector;

public class collisionObject {
	int x = 0;
	float y = 0;
	float yVelocity = 0;
	float yAcceleration = 0;
	int boundingWidth = 0;
	int boundingHeight = 0;

	public boolean checkColliding(Vector<collisionObject> collisionList) {
		for(int i = 0; i < collisionList.size(); i++)
		{
			if(collisionList.elementAt(i) != this)
			{
				int objectOneFinalX = this.x;
				int objectOneFinalY = (int)(this.y + this.yVelocity);
				int objectTwoFinalX = collisionList.elementAt(i).x;
				int objectTwoFinalY = (int)(collisionList.elementAt(i).y + collisionList.elementAt(i).yVelocity);
				
				boolean isColliding = (Math.abs(objectOneFinalX - objectTwoFinalX) * 2 < (this.boundingWidth + collisionList.elementAt(i).boundingWidth)) && 
						(Math.abs(objectOneFinalY - objectTwoFinalY) * 2 < (this.boundingHeight + collisionList.elementAt(i).boundingHeight));

				if(isColliding)
				{
					if(this instanceof Ball)
					{
						
						if(this.yVelocity > 0)
						{
							this.y = collisionList.elementAt(i).y - (collisionList.elementAt(i).boundingHeight/2) - (this.boundingHeight/2);
							//this.yVelocity = -.6f*this.yVelocity;		
						}
						else
						{
							this.y = collisionList.elementAt(i).y + (collisionList.elementAt(i).boundingHeight/2) + (this.boundingHeight/2);
							//this.yVelocity = -.2f*this.yVelocity;		
						}		
						//if((Math.abs(this.yVelocity)) < 1)
							this.yVelocity = 0.0f;
						collisionList.elementAt(i).yAcceleration = 0;
						collisionList.elementAt(i).yVelocity = 0;
					}
					return true;
				}					
			}				
		}
		return false;
	}
}

	