// 2 sum
// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
*   Create a hash map to hold seen elements and its index
*   Traverse through the array
*   if target - current element is present ißn hash map . Return result
*   else add it to hashmap with its index
 * */
class Problem2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i =0; i< nums.length;  i++){
            int n = nums[i];
            if(map.containsKey(target-n)){
                return new int[]{map.get(target-n), i};
            }
            map.put(n,i );
        }
        return new int[]{0,0};
    }
}