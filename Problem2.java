//Problem : Two Sum
//Time Complexity : O(n)
//Space Complexity : O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {

        if(nums.length == 0 ) return null;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length;i++){
            int delta = target - nums[i];

            if(map.containsKey(delta)){
                return new int []{map.get(delta), i};
            }
            map.put(nums[i], i);
        }   
        return null;
    }
}
