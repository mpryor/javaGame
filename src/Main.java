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
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
				myGame.thePaddle.movingLeft = true;
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				myGame.thePaddle.movingRight = true;
		}
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
				myGame.thePaddle.movingLeft = false;
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				myGame.thePaddle.movingRight = false;
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
		final int WINDOWWIDTH = 600;
		final int WINDOWHEIGHT = 500;
        gameRenderer.addKeyListener(inputGrabber);
        gameRenderer.setFocusable(true); 
        JFrame gameWindow=new JFrame();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.add(gameRenderer);
        gameWindow.setSize(WINDOWWIDTH,WINDOWHEIGHT);
        gameWindow.setVisible(true);
        gameWindow.setResizable(false);
	}
}

