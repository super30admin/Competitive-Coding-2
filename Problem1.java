/*
an array is given in the question and you need to return the indices of two numbers such that they add up to a specific target. assume that there is only one solution for each input and you cannot use the same element twice.
Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

// Time Complexity : O(n), go over all elems atleast once
// Space Complexity :O(n) , store all numbers with index.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//nope

// Your code here along with comments explaining your approach
// on each indx get diff between target and val, if seen before return both index.
//if not seen , add this number with indx into map.
//walk for each elem.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int ret[]= new int[2];
        HashMap<Integer, Integer> hmp = new HashMap<>();

        for(int i = 0 ; i < nums.length;i++){
            int diff = target - nums[i];
            int indx0 = hmp.getOrDefault(diff, -1);
            if(indx0 != -1){
                ret[0] = indx0;
                ret[1] = i;
                return ret;
            }
            hmp.put(nums[i],i);
        }
        return ret;
    }
}
