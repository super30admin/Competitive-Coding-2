/**
 * Time Complexity: O(n) (for iterating through the array)
 * Space Complexity: O(n) (for storing indices in a map)
 */

/**
 * First we create a map to store the indices of the elements in the array.
 * We iterate through the array and for each element, we calculate its complement (target - nums[i]) and try to search the complement in the map which means the current element and the complement which is already in the map sum upto the target amount.
 * The current iteration gives the index of the current element and the index of the complement gives the index of the element to which the current element can be added to get the target.
 * As required we return only the indices of the elements.
 */
class indicesofsum {
    public int[] twoSum(int[] nums, int target) {
          Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; 
    }
        
}