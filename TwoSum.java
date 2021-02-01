// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.HashMap;

public class TwoSum {
    
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // populate the hasmap with element as key and index as value
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        // for each element in the array, if (target - element) value exists in the map, it means both the elements add up to the target. return those two indices
        for(int i=0; i<nums.length; i++) {
            int currentDifference = target - nums[i];
            // also check if the returned index isn't the same element's index
            if(map.containsKey(currentDifference) && map.get(currentDifference) != i) {
                int index = map.get(currentDifference);
                return new int[]{i,index};
            }
        }

        return new int[]{-1,-1};
    }

    public static void main(String args[]) {
        int result[] = twoSum(new int[]{2,11,7,15}, 17);

        System.out.println(result[0] + " : " + result[1]);
    }

}