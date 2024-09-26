import sun.lwawt.macosx.CSystemTray;

import java.util.HashMap;

/*
Time Complexity: O(n)
Space Complexity: O(n)
run on leetcode: yes
any difficulties: no

Approach:

1. Use hashmap to store the complement of the target
2. Find out if the complement is there in the given array
3. return the indices
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }else{
                map.put(target-nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int result[] = twoSum(nums, 9);
        System.out.print("indices: ");
        System.out.print("["+result[0]+",\t");
        System.out.print(result[1]+"]");
    }
}
