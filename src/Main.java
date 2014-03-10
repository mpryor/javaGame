import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Main
{
	final static int WINDOWWIDTH = 900;
	final static int WINDOWHEIGHT = 500;
	static Game myGame = new Game(WINDOWWIDTH - 100, WINDOWHEIGHT);
	
	static Renderer gameRenderer = new Renderer(myGame);
	
	static KeyListener inputGrabber = new KeyListener()
	{
		@Override
		public void keyPressed(KeyEvent e) {				
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
				myGame.thePaddle.movingLeft = true;
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				myGame.thePaddle.movingRight = true;
			if(e.getKeyCode() == KeyEvent.VK_CONTROL)
				myGame.magnetism = true;
		}
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
				myGame.thePaddle.movingLeft = false;
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				myGame.thePaddle.movingRight = false;
			if(e.getKeyCode() == KeyEvent.VK_CONTROL)
				myGame.magnetism = false;
		}		
		@Override
		public void keyTyped(KeyEvent e) {}		
	};
	
	public static void main(String[] args)
	{
    	setUpGui();
    	Timer myTimer = new Timer(20, new ActionListener(){
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
        gameRenderer.addKeyListener(inputGrabber);
        gameRenderer.setFocusable(true); 
        gameRenderer.setDoubleBuffered(true);
        JFrame gameWindow=new JFrame();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().add(gameRenderer);
        gameWindow.setSize(WINDOWWIDTH,WINDOWHEIGHT);
        gameWindow.setResizable(false);  
        gameWindow.setVisible(true);      
	}
}

