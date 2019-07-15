/*
{2,5,6,9}
target = 11

5+6=11

11-6 =5
*/
import java.util.HashMap;


class TwoSum
{
	static int[] twoSum(int nums[], int target)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
	
		for(int i=0;i<nums.length;i++)
		{
		
			if(map.containsKey(target-nums[i]))
			{
				return new int[]{map.get(target-nums[i]),i};
			}
			map.put(nums[i],i);
		}
		throw new IllegalStateException("Error");
	}
	
	public static void main(String args[])
	{
		int arr[] = new int[2];
		int nums[] = {2,5,6,9};
		arr = twoSum(nums,13);
		System.out.println(arr[0]+ " "+arr[1]);
	}
}




