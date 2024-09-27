import java.util.HashMap;
//Approach: 1. For solving two sum problem, I have used a hashmap and stored all the numbers of the array.
//2. I iterate through the array again, calculating compliment for each element, and checking if the Hashmap contains it. 
//3. If the hashmap contains compliment, I will assure if its not the same element and return both the indices.
public class TwoSum
{
	public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], i);
        }
        for(int i=0;i<nums.length;i++)
        {
            int compliment = target - nums[i];
            if(map.containsKey(compliment) && map.get(compliment) != i)
                return new int[]{i, map.get(compliment)};
        }
        return new int[0];
    }
}

//Time Complexity : O(n) 
//Space Complexity : O(n) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :