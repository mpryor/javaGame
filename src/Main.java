import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Main
{
	static Game myGame = new Game();
	static Renderer gameRenderer = new Renderer(myGame);
	
	static KeyListener inputGrabber = new KeyListener()
	{
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyChar() == ' ')
				myGame.theBall.isJumping = true;
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
				myGame.theBall.moveLeft = true;
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				myGame.theBall.moveRight = true;
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
				myGame.theBall.moveLeft = false;
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				myGame.theBall.moveRight = false;
			}
		}
		
		@Override
		public void keyTyped(KeyEvent e) {}		
	};
	
	public static void main(String[] args)
	{
    	setUpGui();
    	Timer myTimer = new Timer(25, new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent arg0) {    			
    		//Game Loop start
    			myGame.update();
    			gameRenderer.repaint();	
    		//Game loop end    			
    		}
    	});
    	myTimer.start();
	}
	
	public static void setUpGui()
	{ 
		final int WINDOWWIDTH = 500;
		final int WINDOWHEIGHT = 500;
        gameRenderer.addKeyListener(inputGrabber);
        gameRenderer.setFocusable(true);        
        JFrame gameWindow=new JFrame();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        gameWindow.add(gameRenderer);
        gameWindow.setSize(WINDOWWIDTH,WINDOWHEIGHT);
        gameWindow.setVisible(true);
	}
}

