// Time Complexity : O(n) n is length of array
// Space Complexity : O(n) n is size of hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();//Hashmap to store indices
        
        for(int i=0;i<nums.length;i++){// target:9
            int value = target - nums[i];// 2
            
            if(hashMap.containsKey(value)){
                return new int[]{i, hashMap.get(value)};//If value already exists in hashmap we return indice of that and indce i over here
            }
            else{
                hashMap.put(nums[i],i); //else we put the indices values
            }
        }
        return new int[]{-1,-1};
    }
}
