/*
Desc:
Time Complexity: O(n) in the worst case where the second element lies at the end of the nums array
Space complexity: O(n) as we are using a hashmap. 
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int rSum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int remSum = target-nums[i]; //subtracting current element from target to check if the remainder has occured before by iterating in hashmap.
            if(map.containsKey(remSum)){
                return new int[]{map.get(remSum),i};
            }
            map.put(nums[i],i); //if remainder is not found then the current element is pushed into hashmap.
        }
        return new int[]{-1,-1};
    }
}
