import java.awt.Color;
import java.awt.Graphics2D;

public class Block extends collisionObject implements drawableObject{
	int blockWidth = 80;
	int blockHeight = 20;
	Block()
	{
		x = 246;
		y = 450;
		boundingWidth = blockWidth;
		boundingHeight = blockHeight;
	}
	
	@Override
	public void draw(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.fillRect(x - (blockWidth / 2), (int) (y - (blockHeight / 2)), blockWidth, blockHeight);
	}

}
