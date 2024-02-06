// Two Sum
//Time Complexity : O(n)
//Space Complexity : O(n)
public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        //Dictionary to store num and its index of the array nums
        Dictionary<int, int> map = new Dictionary<int,int>();
        for(int i = 0; i< nums.Length; i++) {
            int diff = target - nums[i];
            // check if the complement of current number exists in dictionary
            if(map.TryGetValue(diff, out var value)) {
                //if so, return the indexes of the numbers whose sum equals target
                return new int[]{value, i};
            }
            else {
                //check and add the entry to dictionary
                if(!map.ContainsKey(nums[i])) {
                    map.Add(nums[i], i);
                }
            }
        }
        return new int[]{-1,-1};
    }
}