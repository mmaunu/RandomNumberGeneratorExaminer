
public class RandomNumberGenerator
{
	private int min, max;
	
	public RandomNumberGenerator(int min, int max)
	{
		this.min = min;
		this.max = max;
	}
	
	public RandomNumberGenerator(int max)
	{
		this.max = max;
		this.min = 1;
	}
	
	public int getNext()
	{
		int value = 1;
		
		value = getNextMathRandom();
		
		return value;
	}
	
	private int getNextMathRandom()
	{
		return (int)(Math.random()*(max - (min - 1))) + min;
	}
}
