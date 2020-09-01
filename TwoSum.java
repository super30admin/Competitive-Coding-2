// Time Complexity : O(n) where n is the length of input array
// Space Complexity : O(n), for hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Took a hasmap, to store the elment and its index, so that we can check if the complement of the target and current element is already present
//when the complement is already present in the map, just return the current index and the index of the complement element
//return the array

class TwoSum{

public int[] twoSum(int[] nums, int target) {
     
    HashMap<Integer, Integer> hm = new HashMap<>();

    int[] res=new int[2];
    for(int i=0;i<nums.length;i++){
        if(hm.containsKey(target-nums[i])){
            res[0]=i;
            res[1]=hm.getValue(target-nums[i]);
            return res;
        }
        hm.put(nums[i],i);
    }
    return res;

}
}