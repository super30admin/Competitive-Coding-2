// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I use a hashmap where I store the element as well as the index at which it occurs in the array. I iterate through each element in the array
 * and if the map contains target-nums[i] as the key, it means that there exists a pair which adds up to the needed target. I then 
 * set ans[0] as map.get(target-nums[i]) (the index of the first number) and ans[1] as i (the index of the other number).
 */
import java.util.HashMap;

// Two Sum
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int []ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                ans[0]=map.get(target-nums[i]);
                ans[1]=i;
                break;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}