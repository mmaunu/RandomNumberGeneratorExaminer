import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.Set;

import javax.swing.JPanel;


public class RandomNumberDataDisplay extends JPanel
{
	private NumberStorageMap numberStorage;
	private int width, height;

	public RandomNumberDataDisplay(int w, int h)
	{
		width = w;
		height = h;

		setBackground(Color.white);
	}

	public void setData(NumberStorageMap ns)
	{
		numberStorage = ns;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		

		if(numberStorage != null)
		{
			Set<Integer> keys = numberStorage.getKeys();
			int maxCount = numberStorage.getMaxValue();
			int minCount = numberStorage.getMinValue();
			int totalCount = numberStorage.getTotalCount();
			int numbKeys = keys.size();
			double expectedCount = (double)totalCount/numbKeys;
			int widthPerKey = this.getWidth()/numbKeys;
			int horizOffset = 0;
			int currValue, currHeight;
			double squaredDeviation, variance = 0;
			DecimalFormat df;
			if(totalCount <= 100) 
				df = new DecimalFormat("#.##");
			else
				df = new DecimalFormat("#.####");
			
			Color boxColor, textColor;
			
			for( int currKey : keys )
			{
				currValue = numberStorage.getCountForKey(currKey);
				currHeight = currValue*this.getHeight()/maxCount;
				squaredDeviation = (currValue - expectedCount)*(currValue - expectedCount);
				variance += squaredDeviation;
				

				
				int clr = 120 + (int)((currValue - expectedCount)*300/expectedCount);
				if( clr > 220 )
					clr = 220;
				else if ( clr < 30 )
					clr = 30;
				
				
				if( currValue < expectedCount )
					boxColor = new Color(0, clr, 0 );
				else
					boxColor = new Color(0, 0, clr);				

				if(currValue == maxCount)
					boxColor = Color.red;
				else if (currValue == minCount)
					boxColor = Color.yellow;

				g.setColor(boxColor);
				
				g.fillRect(horizOffset, this.getHeight() - currHeight - 20, 
						widthPerKey, currHeight - 20);
				g.setColor(Color.black);
				g.drawRect(horizOffset, this.getHeight() - currHeight - 20, 
						widthPerKey, currHeight - 20);
				
				textColor = Color.white;
				if( boxColor.equals(Color.yellow))
					textColor = Color.black;
				g.setColor(textColor);
				
				g.drawString(""+currValue, horizOffset+2,this.getHeight() - 60);
				
				g.drawString(df.format((currValue - expectedCount)/expectedCount), horizOffset+2,this.getHeight() - 40);
				
				horizOffset += widthPerKey;
			}
			
			variance /= (numbKeys - 1);
			
			g.setColor(Color.black);
			g.drawString("variance is: " + df.format(variance) + " and standard deviation is: " + df.format(Math.sqrt(variance)), 20, this.getHeight() - 20);

		}

	}



	public Dimension getSize(){
		return new Dimension( width, height );
	}

	public Dimension getMinimumSize(){
		return getSize();
	}

	public Dimension getMaximumSize(){
		return getSize();
	}

	public Dimension getPreferredSize(){
		return getSize();
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}


}
