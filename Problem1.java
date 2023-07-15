//Time Complexity: O(n)
//Space Complexity: O(n)
//Solved on leetcode: yes
//explanation: store numbers in hashmap and try to find out if compliment number exists in map
//Code
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer, Integer> map= new HashMap<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])) //checking if compliment exists in map, if yes just return the 2 indexes
                return new int[]{map.get(target-nums[i]), i};
            else
                map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}