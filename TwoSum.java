//The approach here is to use a hashmap to store the pairs of remaining value required to reach target as key and it's index as value
//Time Complexity:O(n);
//Space Complexity: O(n) for hashmap

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int first=0; int second=0;
        for(int i = 0; i<nums.length; i++){
            first = i;
            int other = target-nums[i];
            if(map.containsKey(nums[i])){
                second = map.get(nums[i]);
                break;
            } else{
                map.put(other, i);
            }
        }
        return new int[] {first,second};
        
    }
}