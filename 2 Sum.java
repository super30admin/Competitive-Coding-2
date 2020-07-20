//2 Sum

//TC: O(n), n: number of elements in the array nums
//SC: O(n),
//Approach:
//1. We store every element with it's index in a hashmap.
//2. With every iteration, we check if the complement of the current element is already in the hashmap, if no, we simply put the element in hashmap, 
// if yes, then current element and it's complement, together can make a sum equal to target.
// So, we return the indexe of the complement and the current index.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
