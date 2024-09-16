class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }
            System.out.println(map);
        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
            System.out.println(i);
            int complement = target-nums[i];
            if(map.containsKey(complement ) && map.get(complement)!= i ) {
                return new int [] {i,map.get(complement)};
            }
        }
         return new int[]{-1,0};
        
        
    }
}
