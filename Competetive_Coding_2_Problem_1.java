import java.util.HashMap;

//Time Complexity : O(n)
//Space Complexity: O(n) Hashmap
//Run successfully on leetcode
//Problem : No problem

//While traversing through the array, we will be checking if the
//Complement has already occured or not, if not, we will be adding the element into the HashSet


public class Competetive_Coding_2_Problem_1 {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[0];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i =0 ; i < nums.length ; i ++)
        {
            if(hm.containsKey(target - nums[i]))
            {
                return new int[]{hm.get(target - nums[i]),i};
            }
            else
            {
                hm.put(nums[i],i);
            }
        }
        return new int[0];
    }
}
