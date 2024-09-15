// Time Complexity: O(n) 2 passes through nums array
// Space Complecity: only constant space used: O(1)
// Did you complete it on leet code: yes
// Any problems faced: no

// Write your approach here:
// In case of all positive values, we are checking if target is lesser than minimum element and return -1,-1 in that case
// otherwise we are checking if there is an element exists in map whose sum with current num element could give us target value
// if yes, we assign it to result array and return
// otherwise we continue checking on each array element
public class Solution{
    public int[] calculate(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        result[0] = -1;
        result[1] = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length;i++) {
            min = Math.min(min, nums[i]);
        }
        if(target<min) {
            return result;
        }
        for(int i=0; i<nums.length; i++) {
            // if our map already contains a value which sums up to target
            if(i==nums.length-1 && !map.containsKey(target-nums[i])) {
                return result;
            }
            if(map.containsKey(target-nums[i])) {
                result[0] = map.get(target-nums[i]);
                result[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}