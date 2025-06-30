// This solution solves the two-sum problem using 1 pass solution with a hashmap.
// TC: O(1) since we are iterating over the array one single time and insertions and lookups on the map is O(1) complexity
// SC: O(n) in the worst case, we would insert all n elements in the map which is o(n)
// Brute Force: two for loops - O(n^2) time complexity and O(1) space complexity
// Two pass solution - one pass to insert into the map and one pass to look up from the map - O(n) overall tc and O(n) space complexity 
// Two pointers - We can also use two pointers to scan from each end - after sorting 
// TC: O(nlogn) to sort and O(n) for pass and SC: O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
          // Check if map already contains sompliment
            if (map.containsKey(target - nums[i])){
              // If it coontains, just get the index and return index of value and compliment
                result[0] = map.get(target-nums[i]);
                result[1] = i;
            }
          // If map does not contain current key, enter current key with value as the index
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
