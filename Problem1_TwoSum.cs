// Approach : store each element in the map, calculate the diff from target and see if we have come across this required diff at a previous index
// Time Complexity : O(n), n is the size of nums
// Space Complexity: O(n)
public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        Dictionary<int, int> map = new Dictionary<int, int>();
        for(int i=0; i< nums.Length; i++){
            int diff = target - nums[i];
            
            if(map.ContainsKey(diff))
                return new int[] {map[diff], i};
            else if(!map.ContainsKey(nums[i]))
                map.Add(nums[i], i);
        }
        
        return new int[0];
    }
}
