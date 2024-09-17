// Time complexity - O(n)
// Space complexity - O(n)

// Implemented using hashmap by taking nums[i] as key and index as value. Check if target - nums[i] already present in the map, then return indexes.


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int t = target - nums[i];
            if(map.containsKey(t)){
                return new int[]{map.get(t),i};
            }else{
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("No two sum solution"); 
    }
}
