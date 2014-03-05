import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

class Renderer extends JPanel{
	
	private static final long serialVersionUID = 1L;	
	Game myGame;
	Renderer(Game currentGame)
	{
		myGame = currentGame;
	}
	//Fills the background color
	public void colorBG(Graphics2D g2)
	{
		g2.setColor(Color.black);
		g2.fillRect(0,0,this.getWidth(), this.getHeight());
		g2.setColor(Color.WHITE);
		g2.fillRect(0,0,500,500);
	}
	
	//Primary draw method
	@Override
    public void paintComponent(Graphics g)
    { 	  
	  Graphics2D g2 = (Graphics2D)g.create();
	  colorBG(g2);
      for(int i = 0; i < myGame.drawList.size(); i++)
      {
    	  myGame.drawList.elementAt(i).draw(g2);
      }
	  g2.setColor(Color.WHITE);
	  g2.setFont(new Font("TimesRoman", Font.PLAIN, 50)); 
      g2.drawString(String.valueOf(myGame.blocksDestroyed), 520, 50);
      g2.drawString(String.valueOf(myGame.lives), 520, 100);
    }        
}