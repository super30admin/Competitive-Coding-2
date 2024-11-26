// Time Complexity : O(n) for get, put, and remove
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach

public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2]; //output array
    HashMap<Integer, Integer> map = new HashMap<>();
    
    for(int i = 0; i < nums.length; i++){
        //if the map contains the target - current element, then current element and the result of the subtraction
        //are the two elements which add up to the target. we put the index value of
        //both these numbers in the new array and return the result array
        if(map.containsKey(target - nums[i])){
            result[0] = i;
            result[1] = map.get(target - nums[i]);
        }
        else{
            map.put(nums[i],i);
        }
    }
    return result;
}