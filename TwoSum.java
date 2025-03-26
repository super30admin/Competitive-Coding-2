//Time Complexity: O(n)
//Space Complexity: O(n)
//Did this code successfully run on Leetcode : Yes

/*Approach:
1. Iterate through the list of elements and store its value and index in a Hashmap
2. While iterating also keep checking if the elements's complement(target-element) already exists in the hashmap
3. If exists, then we have the found the pair. return the current index and the complement's index
 */
class Solution {
    
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){

            int complement=target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}