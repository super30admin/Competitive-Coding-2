// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes

// Your code here along with comments explaining your approach
// while iterating over the array , calculate the complement and check if it is present in hashmap
// if it is , add the indices of the number and complement otherwise add the complement and its index to the hashmap

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target- nums[i];
            if(hmap.containsKey(complement)){
                return new int[]{hmap.get(complement),i };
            }
            hmap.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
