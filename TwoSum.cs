//TC: O(n)
//SC: O(n)

public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        Dictionary<int, int> indexes = new Dictionary<int, int>();

        for(int i=0; i<nums.Length; i++){
            int diff = target - nums[i];
            if(indexes.ContainsKey(diff)){
                return new int[] {indexes[diff], i};
            }

            indexes[nums[i]] = i;
        }
        return null;
    }
}