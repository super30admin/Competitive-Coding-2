class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer,Integer> h = new HashMap<>();
        for(int i =0 ;i<nums.length;i++)
        {
            h.put(nums[i],i);
        }
        
        
        for(int i = 0 ;i<nums.length;i++)
        {int compliment= target - nums[i];
            if(h.containsKey(compliment) && h.get(compliment) != i)
            {
                return new int[] {i,h.get(compliment)};
            }
        }
        return new int []{};
    }
     
}


/*
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0 ;i<array.length;i++)
		{
			map.put(array[i],i);
		}
		for(int i = 0 ;i<array.length;i++)
		{
			int num = targetSum - array[i];
			if(map.containsKey(num) && map.get(num) != i)
			{
				return	new int[] {array[i],num};
				//return new int[] {i,h.get(compliment)};
			}
			else{
				return new int[0];
			}
		}
		
    return new int[0];
    */