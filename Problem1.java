//Time Complexity : O(1)
//Space Complexity : O(1)
import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            //calculate result by target - current element
            int result = target-nums[i];
            //if result is present return the index of result's index and nums[i] index
            if(map.containsKey(result) ){
                return new int[] {map.get(result),i};
            }
            //if result is not present put it into map
            else{
                map.put(nums[i],i);
            }
        }
        
        return null;
    }
}