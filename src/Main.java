import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Main
{
	static DrawPanel draw;
	public static void main(String[] args)
	{
	    	play();
	    	Timer myTimer = new Timer(25, new ActionListener(){
	    		@Override
	    		public void actionPerformed(ActionEvent arg0) {
	    			draw.step();
	    			draw.repaint();			
	    		}
	    	});
	    	myTimer.start();
	}

	public static void play()
   { 
			final int WINDOWWIDTH = 500;
			final int WINDOWHEIGHT = 500;
            JFrame frame=new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            draw = new DrawPanel();  
            draw.addKeyListener(draw);
            draw.setFocusable(true);            
            frame.add(draw);
            frame.setSize(WINDOWWIDTH,WINDOWHEIGHT);
            frame.setVisible(true);
     }
 }

