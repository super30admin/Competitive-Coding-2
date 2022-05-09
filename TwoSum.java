//Time Complexity : O(N)
//Space Complexity: O(N)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> visited = new HashMap<>();
        int[] resultant = new int[2];
        for(int i=0;i<nums.length;i++) {
            // at every iteration, we find out the remaining, when substracting the target with the current value
            // if it is already present in our hashMap, we return the value of it, which is, the position it can be found at.
            if(visited.containsKey(target-nums[i])) {
                resultant[0]= visited.get(target-nums[i]);
                resultant[1]= i;
                break;
            }
            // keeping track of every elements, element with its position in the given array
            visited.put(nums[i], i);
        }
        return resultant;
    }
}
