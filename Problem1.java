//Time Complexity : O(n)
//Space Complexity : O(n)
// Solved on leetcode - yes
// Did you face any issues - no
class Solution {
    public int[] twoSum(int[] nums, int target) {

        if(nums.length == 0 ) return null;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length;i++){
            int difference = target - nums[i];

            if(map.containsKey(difference)){
                return new int []{map.get(difference), i};
            }
            map.put(nums[i], i);
        }   
        return null;
    }
}
