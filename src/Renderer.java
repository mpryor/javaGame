import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Renderer extends JPanel{
	
	private static final long serialVersionUID = 1L;	
	final int ballWidth = 50; 
	final int ballHeight = 50;
	Game myGame;
	Renderer(Game currentGame)
	{
		myGame = currentGame;
	}
	@Override
    public void paintComponent(Graphics g)
    { 
      g.setColor(Color.WHITE);
      g.fillRect(0,0,this.getWidth(),this.getHeight());
      g.setColor(Color.GREEN);
      g.fillOval(myGame.x,(int)myGame.y,ballWidth,ballHeight);
    }         
}