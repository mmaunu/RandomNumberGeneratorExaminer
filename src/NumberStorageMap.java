import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class NumberStorageMap
{
	private Map<Integer, Integer> frequencyStorage;
	private int numEntries;
	
	public NumberStorageMap()
	{
		frequencyStorage = new HashMap<Integer, Integer>();
		numEntries = 0;
	}
	
	public void addOccurence(int key)
	{
		if( frequencyStorage.containsKey(key) )
			frequencyStorage.put(key, frequencyStorage.get(key) + 1);
		else
			frequencyStorage.put(key, 1);
		numEntries++;
	}
	
	public int getCountForKey(int key)
	{
		if( frequencyStorage.containsKey(key) )
			return frequencyStorage.get(key);
		else
			return 0;
	}
	
	public int getTotalCount()
	{
		return numEntries;
	}
	
	public Set<Integer> getKeys()
	{
		return frequencyStorage.keySet();
	}
	
	public int getMaxValue()
	{
		int max = 0;
		for( int currKey: frequencyStorage.keySet() )
		{
			if( frequencyStorage.get(currKey) > max )
				max = frequencyStorage.get(currKey);
		}
		return max;
	}
	
	public int getMinValue()
	{
		int min = getMaxValue();
		for( int currKey: frequencyStorage.keySet() )
		{
			if( frequencyStorage.get(currKey) < min )
				min = frequencyStorage.get(currKey);
		}
		return min;
	}
	
	public void clear()
	{
		frequencyStorage.clear();
		numEntries = 0;
	}
	
	public String toString()
	{
		String ret = "";
		
		Set<Integer> keys = frequencyStorage.keySet();
		for( int currKey: keys )
		{
			ret += currKey + ":" + frequencyStorage.get(currKey) + "\n";
		}
		return ret;
	}
}
