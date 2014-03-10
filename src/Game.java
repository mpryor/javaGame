import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Game {

	Vector<movingObject> movingList = new Vector<movingObject>(10,2);
	Vector<collisionObject> collisionList = new Vector<collisionObject>(10,2);
	Vector<collisionObject> nonStaticObjects = new Vector<collisionObject>(10,2);
	Vector<drawableObject> drawList = new Vector<drawableObject>(10,2);
	Ball theBall = new Ball(this);	
	Paddle thePaddle = new Paddle(this);
	boolean magnetism = false;
	final int MAXLIVES = 3;
	int blocksDestroyed = 0;
	int numberOfBlocks;
	int lives = MAXLIVES;
	int width;
	int height;	

	public enum SoundEffect
	{
		BLOCK("hit.wav"),
		PADDLE("Paddle.wav"),
		DEATH("Death.wav");
		
		private Clip clip;
		
		SoundEffect(String soundFileName) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFileName).getAbsoluteFile());
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	      } catch (UnsupportedAudioFileException e) {
	      } catch (IOException e) {
	      } catch (LineUnavailableException e) {
	      }
	   }
		
	   public void play() 
	   {		    	 
		   clip.stop();
		   clip.setFramePosition(0); // rewind to the beginning
		   FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		   gainControl.setValue(-20.0f); // Reduce volume by 10 decibels.
		   clip.start();     // Start playing
	   }	   
		   // Satic method to pre-load all the sound files.
	   static void init() {
		   values();
	   }
	}
	
	Game(int currWidth, int currHeight)
	{
		width = currWidth;
		height = currHeight;
		SoundEffect.init();
		drawList.add(theBall);
		drawList.add(thePaddle);
		movingList.add(theBall);
		movingList.add(thePaddle);
		collisionList.add(theBall);
		collisionList.add(thePaddle);
		nonStaticObjects.add(theBall);			
		addBlocks(collisionList, drawList);		
	}
	
	public void reset()
	{
		SoundEffect.DEATH.play();
		thePaddle.reset();
		theBall.reset();
		if(lives == 0)
		{
			gameOver();
		}
		else
			lives--;

	}
	public void gameOver()
	{
		drawList.removeAll(drawList);
		collisionList.removeAll(collisionList);
		movingList.removeAll(movingList);
		
		drawList.add(theBall);
		drawList.add(thePaddle);
		movingList.add(theBall);
		movingList.add(thePaddle);
		collisionList.add(theBall);
		collisionList.add(thePaddle);
		nonStaticObjects.add(theBall);			
		addBlocks(collisionList, drawList);
		lives = MAXLIVES;
		blocksDestroyed = 0;
		
	}

	public void update()
	{
		for(int i = 0; i < movingList.size(); i++)
		{			
			movingList.elementAt(i).update();		
		}
		for(int i = 0; i < nonStaticObjects.size(); i++)
		{
			nonStaticObjects.elementAt(i).checkColliding(collisionList, drawList, this);
		}
		for(int i = 0; i < movingList.size(); i++)
		{
			movingList.elementAt(i).move();
		}
		if(numberOfBlocks == 0)
		{
			addBlocks(collisionList,drawList);
			thePaddle.reset();
			theBall.reset();
			lives++;
		}
			
	}
	
	public void addBlocks(Vector<collisionObject> collisionList, Vector<drawableObject> drawingList)
	{
		int numberOfRows = 4;
		int numberOfColumns = 8;
		numberOfBlocks = numberOfRows * numberOfColumns;
		int verticalSpacing = 10;
		int horizontalSpacing = 10;
		int initialY = 50;
		for(int currentRow = 1; currentRow <= numberOfRows; currentRow++)
		{
			for(int currentColumn = 1; currentColumn <= numberOfColumns; currentColumn++)
			{
				Block newBlock = new Block();
				newBlock.x = currentColumn * (newBlock.blockWidth + horizontalSpacing);
				newBlock.y = currentRow * (newBlock.blockHeight + verticalSpacing) + initialY;
				collisionList.add(newBlock);
				drawingList.add(newBlock);
			}
		}
		

	}

}
