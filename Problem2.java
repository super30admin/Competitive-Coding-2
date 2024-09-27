import java.util.HashMap;
//Time complexity : N
//space complexity: N
// did it run on leetcode: yes
//Any doubts : No
//https://leetcode.com/problems/two-sum/
//TwoSum
public class Problem2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hp = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            hp.put(nums[i],i);
        }
        for(int i =0;i<nums.length;i++){
            int complement = target - nums[i];
            if(hp.containsKey(complement) && hp.get(complement) != i){
                return new int[]{i,hp.get(complement)};
            }
        }
        return new int[] {-1,-1};
     }

}
