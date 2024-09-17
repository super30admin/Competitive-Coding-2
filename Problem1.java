/*  Time complexity: O(n)
Space complexity: O(n)

1. Using hashmap to implement the two sum problem.
2. The aim is to find the index of distinct numbers that add upto the target. (y=Target-element) is stored for each number in the array, so that when we encounter y in the array,
and check for its existence, if present, we know that in the past it has occured and would add upto the target
3. Continue in the same fashion for the rest of the array elements. */


class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] array = new int[2];
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put((target-nums[i]), i);
            }
            else{
                array[0] = map.get(nums[i]);
                array[1] = i;            
            }
        }
        
        return array;
    }
}