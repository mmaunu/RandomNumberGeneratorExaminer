import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class RandomImageMaker extends JPanel
{
	
	private int width, height;
	
	public RandomImageMaker(int w, int h)
	{
		width = w;
		height = h;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), 
						BufferedImage.TYPE_INT_RGB);
		
		int white = 0xffffff;
		int red = 0xff0000;
		int green = 0x00ff00;
		int blue = 0x0000ff;
		int black=0x000000;
		
		double blah;
		
		for(int r = 0; r < this.getHeight(); r++)
		{
			for( int c = 0; c < this.getWidth(); c++)
			{
				blah = Math.random();
				if( blah < .2 )
					img.setRGB(c, r, white);
				else if( blah < .4 )
					img.setRGB(c, r, red);
				else if (blah < .6 )
					img.setRGB(c, r, green);
				else if (blah < .8 )
					img.setRGB(c, r, blue);
				else
					img.setRGB(c, r, black);
			}
		}
		g.drawImage(img,0,0,null);
		try
		{
			Thread.sleep(10);
			repaint();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Yo!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		
		RandomImageMaker rim = new RandomImageMaker(500, 500);
		frame.getContentPane().add(rim);
		frame.setVisible(true);
	}
	
	
//	public Dimension getSize(){
//		return new Dimension( width, height );
//	}
//
//	public Dimension getMinimumSize(){
//		return getSize();
//	}
//
//	public Dimension getMaximumSize(){
//		return getSize();
//	}
//
//	public Dimension getPreferredSize(){
//		return getSize();
//	}
//
//	public int getWidth(){
//		return width;
//	}
//
//	public int getHeight(){
//		return height;
//	}

}
