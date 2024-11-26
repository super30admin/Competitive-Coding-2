// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach: Storing the values in the hashmap and at each iteration checking for target-nums[i] is already present in the hashmap if it does then we found the sum and returning the indexes.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> h = new HashMap<>(); 
        
        int[] arr = new int[2];
        for(int i=0;i<nums.length;i++){
                if(h.containsKey(target-nums[i])){
                        arr[0] = h.get(target-nums[i]);
                        arr[1] = i;
                }
            else{
                h.put(nums[i],i);
            }
        }
        return arr;
    }
}
