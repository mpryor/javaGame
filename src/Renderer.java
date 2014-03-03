import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

class Renderer extends JPanel{
	
	private static final long serialVersionUID = 1L;	
	Game myGame;
	Renderer(Game currentGame)
	{
		myGame = currentGame;
	}
	//Fills the background color
	public void colorBG(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillRect(0,0,this.getWidth(),this.getHeight());
	}
	//Primary draw method
	@Override
    public void paintComponent(Graphics g)
    { 
	  colorBG(g);
      for(int i = 0; i < myGame.drawList.size(); i++)
      {
    	  myGame.drawList.elementAt(i).draw(g);
      }
    }        
}