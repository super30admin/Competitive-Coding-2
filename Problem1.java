// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No
// Approach:
// We iterate through the array and store each number and its index in a hashmap.
// For each number, we check if (target - current number) exists in the map.
// If it does, we found the two indices whose values sum to the target and return them.



import java.util.Arrays;
import java.util.HashMap;
class Problem1{
    public int [] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int find = target - nums[i];
            if(hmap.containsKey(find)){
                return new int[] {hmap.get(find), i};

            }
            else{
                hmap.put(nums[i], i);
            }
        }
        return new int [] {};

    }
    public static void main(String[]args){
        Problem1 ob = new Problem1();
        int[] nums1 = new int[] {2,7,11,15};
        int[] nums2 = new int[] {3,2,4};
        int[] nums3 = new int[] {3,3};
        System.out.println(Arrays.toString(ob.twoSum(nums1, 9)));
        System.out.println(Arrays.toString(ob.twoSum(nums2, 6)));
        System.out.println(Arrays.toString(ob.twoSum(nums3, 6)));
        
    }
}