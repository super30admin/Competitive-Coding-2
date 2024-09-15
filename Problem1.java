//o(n) time and space
//passed all leetcode cases
//used hashmap and compliments
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int comp = target-nums[i];
            if(hp.containsKey(comp)){
                return new int[] {hp.get(comp),i};
            }
            hp.put(nums[i],i);

        }
        return null;

    }
}