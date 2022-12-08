// Two Sum
// Time: O(n)
// Space: O(n)

// Approach
// Consider a hashmap & the resultant array
// for a particular element, will check its complement(target - that number) is present in the hashmap or not. If present will return both index as result.
//If not present will store the index & the complement of that number.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> check = new HashMap<>();

        for(int i =0; i<nums.length; i++) {
            if(check.containsKey(nums[i])) {
                res[0] = check.get(nums[i]);
                res[1] = i;
                return res;
            }
            else
                check.put(target - nums[i], i);
        }
        return res;
    }
}