import java.awt.Color;
import java.awt.Graphics;

public class Block extends collisionObject implements drawableObject{
	int blockWidth = 80;
	int blockHeight = 50;
	Block()
	{
		x = 246;
		y = 450;
		boundingWidth = 80;
		boundingHeight = 50;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x - (blockWidth / 2), (int) (y - (blockHeight / 2)), blockWidth, blockHeight);
	}

}
