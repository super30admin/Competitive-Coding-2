//Problem 1: Two Sum
//Leetcode : https://leetcode.com/problems/two-sum/description/

/*
    Time Complexity: O(n)
    - We traverse the array 'nums' exactly once.
    - Each lookup and insertion in the HashMap takes O(1) on average.

    Space Complexity: O(n)
    - In the worst case, we store all 'n' elements of the array in the HashMap.

    Approach: One-Pass Hash Map
    - As we iterate through the array, we check if the 'complement' (target - current number)
      already exists in our map.
    - If it exists, it means we found the two numbers that add up to the target.
    - If not, we store the current number and its index in the map to check against future numbers.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] result = new int[2];
        for(int i=0; i < nums.length; i++ ){
            if(map.containsKey(target - nums[i])){

                result[0] = i;
                result[1] = map.get(target-nums[i]);
                break;

            }else{
                map.put(nums[i],i);
            }
        }

        return result;

    }
}