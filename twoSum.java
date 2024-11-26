//time complexity: O(n)
//space complexity: O(n)
import java.util.*;
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
        
        map.put(nums[0], 0);
        
        for(int i = 1; i < nums.length; i++){
            int val = target - nums[i];
            if(map.containsKey(val)){
                ans[0] = map.get(val);
                ans[1] = i;
                return ans;
            }else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}