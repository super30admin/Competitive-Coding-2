// Leetcode problem 1
class Solution {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
    */
    public int[] twoSum(int[] nums, int target) {
        // check if the array is empty or not
        if(nums.length == 0){
            return new int[2];
        }
        
        int n = nums.length;
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int[] output = new int[2];
        
        // add elements from the array to the hashmap
        for(int i = 0; i < n; i++){
            hmap.put(nums[i], i);
        }
        
        for(int i = 0; i < n; i++) {
            
            int c = target - nums[i];
            // check if the other number is present in the hmap or not
            if(hmap.containsKey(c) && hmap.get(c) != i){
                output[0] = i;
                output[1] = hmap.get(c);
            }
        }
        // return the final array
        return output;
    }
}