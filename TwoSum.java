//Amazon Interview
//Time Complexity = O(n)
//Space Complexity =O(1)
//Here we will be iterating over every element and storing that in a map with its index then once again we will be iterating over that array and find the complement at every place; if that complement exists and the value of that complement(key in map) is not equal to the index of the current value in array then that means we have got the pair which sum to the target.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i<nums.length;i++){
            int complement = target-nums[i];
            if(map.containsKey(complement) && map.get(complement)!=i){
                return new int[] {i,map.get(complement)};
            }
        }
        return new int[] {-1,-1};
    }
}