import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

class DrawPanel extends JPanel implements KeyListener{
	int x = 246 - 25;
	float y = 50;
	int reverse = 1;
	float yVelocity = 0;
	float yAcceleration = 0.5f;
	
    public void paintComponent(Graphics g)
    { 
      g.setColor(Color.WHITE);
      g.fillRect(0,0,this.getWidth(),this.getHeight());
      g.setColor(Color.GREEN);
      g.fillOval(x,(int)y,50,50);
    }
    
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == ' ')
		{
			yVelocity -= 20;
					
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {	
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	public void step()
	{
		yVelocity += yAcceleration;
		y += yVelocity;
	}
     
}