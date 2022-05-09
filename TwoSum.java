//Time Complexity : O(N)
//Space Complexity: O(N)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> visited = new HashMap<>();
        int[] resultant = new int[2];
        for(int i=0;i<nums.length;i++) {
            if(visited.containsKey(target-nums[i])) {
                resultant[0]= visited.get(target-nums[i]);
                resultant[1]= i;
                break;
            }
            visited.put(nums[i], i);
        }
        return resultant;
    }
}