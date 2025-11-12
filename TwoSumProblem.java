import java.util.HashMap;

//Idea is to use Hashmap to store the value and index.
//While inserting into the hashmap we simultaneously check for the compliment value (target-current value) 
// Time Complexity: O(n)
// Space Complexity: O(n)
public class TwoSumProblem{

        public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(target-nums[i]))
            {
                return new int[]{i,hm.get(target-nums[i])};
            }
            else
            {
                hm.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }
}