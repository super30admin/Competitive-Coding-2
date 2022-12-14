// Time Complexity: O(n)
// Space Complexity = O(n)

/*
 * here we are going through the array and storing the difference in hashmap
 * if we find the element in array equal to hashmap key we return the index 
 * of the element and the value of the hashmap.
 */
import java.util.HashMap;

class TwoSum{
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> difference = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(difference.containsKey(nums[i])){
                return new int[] {difference.get(nums[i]), i};
            }
            difference.put(target-nums[i], i);
        }
        return new int[] {};
    }
}