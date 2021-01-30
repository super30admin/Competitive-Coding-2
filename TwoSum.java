/** Time Complexity: O(N) where N is the length of input array
 *  Space Complexity: O(N) where N is the length of input array
 * LeetCode: Y (https://leetcode.com/problems/two-sum)
 *  Approach: 
        Intialize a HashMap to store key-value pairs of <operand1, operand1's index>
        Traverse through the array:
            first check if the complement of nums[i] was already seen before.
            If the complement was seen before return [value of hashmap entry, current index i.e i]
            else insert a new key-value pair of <nums[i], i> in the hashmap
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Intialize a HashMap to store key-value pairs of <operand1, operand1's index>
        Map<Integer, Integer> numberToIndexMapping = new HashMap<Integer, Integer>();
        
        // Traverse through the array:
        for(int i = 0 ; i < nums.length ; i++) {
            // Calculate complement of nums[i]
            int complement = target - nums[i];
            
            // Check if the current element's complement was seen before i.e. this is the valid answer
            if(numberToIndexMapping.containsKey(complement)) {
                // return the two indices
                return new int[]{numberToIndexMapping.get(complement),i};
            }
            // Insert a new key-value pair of <nums[i], i> in the hashmap for lookup later
            numberToIndexMapping.put(nums[i], i);
        }
        
        return new int[]{-1 ,-1};
        
    }
}
