//TC - O(n)
//SC- O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int pair = target - nums[i];
            if(map.containsKey(pair)){
                return new int[] {map.get(pair), i };
            }else{
                map.put(nums[i], i);
            }
        }

        return new int[]{};
        
    }
}