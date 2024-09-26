//TC: O(N)
//SC: O(N)

import java.util.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i = 0; i < nums.length; i++) {

            //Add the difference in a map
            //if it contains the second number of the sum, we have found the pair
            if(!map.containsKey(target-nums[i])) {
                map.put(nums[i],i);
            } else {
                return new int[] {i, map.get(target-nums[i])};
            }
        }
        return new int[]{};
    }

    public static void main(String args[]) {
        TwoSum twosum = new TwoSum();
        int output[] = twosum.twoSum(new int[]{2,7,10,15}, 9); 
        System.out.println("Two numbers present at: "+output[0]+","+output[1]);
    }
}

/**
OP:
Two numbers present at: 1,0
 */