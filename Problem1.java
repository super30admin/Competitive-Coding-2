// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// We store the elements as a hash map
// then check if target-element already exists in hashmap
// if it exists then we return the two indices
//

// Your code here along with comments explaining your approach
import java.util.Arrays;
import java.util.HashMap;

class Problem1 {
    public static void main(String args[]) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        int[] nums2 = {3,2,4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target2)));
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                break;
                       
            }
            else {
                map.put(nums[i],i);
            }
        }
        return res;
    }
}