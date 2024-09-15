// Time Complexity : O(n) where n is the length of input array
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/* https://leetcode.com/problems/two-sum/ */

// Method -3 One pass hashing solution
class Solution {
    public int[] twoSum(int[] nums, int target) {

        if(nums == null || nums.length == 0)
            return null;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++ ){
            int complement = target -  nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void  main (String[] args){
        System.out.println("Hello");
    }
}


/* Two Pass Hashing Solution - Method 2
TC: O(n) where n is the length of input array
SC: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {

        if(nums == null || nums.length == 0)
            return null;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++ ){
            map.put(nums[i], i);
        }


        for(int i = 0 ; i< nums.length ; i++){
            int complement = target -  nums[i];
            if(map.containsKey(complement) && map.get(complement) != i)
                return new int[] {i, map.get(complement)};
        }
        return null;
    }
}
 */
/*
//Brute Force method - 1
 TC: O(n^2) where n is the length of input array
SC : O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {

        if(nums == null || nums.length == 0)
            return null;

        for(int i = 0 ; i < nums.length ; i++ ){
            for(int j = i+1 ; j < nums.length ; j++ ){
                if(nums[j] == target - nums[i]);
                return new int[] {i,j} ;
            }
        }
        return null;
    }
}
*/


