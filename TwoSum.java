class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map <Integer, Integer> map= new HashMap<>();
        for (int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i=0; i<nums.length; i++){
            int neg= target- nums[i];
            if(map.containsKey(neg) && map.get(neg) !=i) return new int []{i, map.get(neg)};
        }
        return new int []{-1,-1};
    }
}T