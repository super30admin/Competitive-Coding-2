import java.util.*;

public class Problem1 {
// Time Complexity : O(n)
// Space Complexity : O(n) n-> entries in the hashSet
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public int[] twoSum(int[] nums, int target) {
    HashMap<Integer,Integer> hm = new HashMap<>();
    int[] ans = new int[2];
    
    for(int i=0;i<nums.length;i++){
        hm.put(nums[i],i);
    }
    
    for(int i=0;i<nums.length;i++){
    int diff = target - nums[i];
    //     System.out.println(diff);
      //  System.out.print(hm);
        
        if(hm.containsKey(diff) && i!=hm.get(diff)){
            ans[0]=i;
            ans[1]=hm.get(diff);
            return ans;
            
        }
     
    
    }
    return ans;
}
}