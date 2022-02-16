// space complexity - o(n)
    //time - o(n)
    //Ran on leeetcode successfully : Yes
    // Problem faced  : No
    //Approach : for current element check if the differnce from target exists in map else add the element in map 

class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
