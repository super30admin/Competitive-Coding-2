Leetcode: 1. Two Sum
//  Time Complexity : O(n) // n is number of elements in nums
//Space complexity : O(n)   // n is number of elements in nums
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums== null ){
            return new int[0];
        }
        HashMap<Integer,Integer> hm =new HashMap<>();
        int[] res = new int[2];
        for(int i=0;i< nums.length;i++){
            
            if(hm.containsKey(target-nums[i])){
                res[1]= i;
                res[0]= hm.get(target-nums[i]);
                return res;
            }
            else{
                hm.put(nums[i],i);
            }
        }
        return new int[0];
        
    }
}