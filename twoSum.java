//time complexity: O(N)
//Space complexity: O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //base case-if array is empty
        if(nums.length==0)
            return new int[]{-1,-1};
        //initialize a hashMap for the numbers that are visited
        //key->array element, value->index
        HashMap<Integer, Integer> hMap=new HashMap<>();
        //now iterate over the nums in the array
        for(int i=0;i<nums.length;i++){
            //find out the difference between the target and the number
            int diff=target-nums[i];
            //if the diff is already in the hMap
            if(hMap.containsKey(diff))
                //return the array current index and index of diff which is already in the map
                return new int[]{i, hMap.get(diff)};
            //if it is not present, then we add it to the hMap
            hMap.put(nums[i],i);
        }
        //if the target is not present in the given array
        return new int[]{-1,-1};
    }
}