import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
public class Animation
{
	public static void main(String[] args)
	{
	    	 	Animation gui=new Animation();
	    	 	gui.play();
	}
	public void play()
   {
           JFrame frame=new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            DrawPanel draw = new DrawPanel();  
            draw.addKeyListener(draw);
            draw.setFocusable(true);            
            frame.add(draw);
            frame.setSize(500,500);
            frame.setVisible(true);
            while(draw.y < 500)
            {
               draw.step();	
               draw.repaint();  //tells the panel to redraw itself so we can see the circle in new location             
               try {
            	   Thread.sleep(25);
			   } catch (InterruptedException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			   }          
         }
     }
 }

