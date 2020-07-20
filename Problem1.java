/**
Problem: Two Sum

Time Complexity : O(n), where n is the size of the 'nums' array
Space Complexity : O(n), where n is the size of the 'nums' array


Approach: Use a hashmap
1. If a given element of the array is not present in the hashmap, then we place it in the hashmap.
2. The elements of the array act as keys, and its indices as values in the hashmap.
3. Next, we check if the complement(i.e, target minus the present element) is already present in the hashmap, and it's indices are different.
4. If the above condition is satisfied, we return the indices of numbers that add up to the target.
 */


class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        for(int i = 0; i < nums.length; i++) {
            int comp = target-nums[i];
            if(!hm.containsKey(nums[i])) {
                hm.put(nums[i],i);
            }
            if(hm.containsKey(comp) && hm.get(comp) != i) {
                result[0] = i;
                result[1] = hm.get(comp);
            }
        }
        return result;
    }
}