// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

import java.util.*;

class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int contained;
        List<Integer> disappeared = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
            contained = nums[i];
            if(contained < 0)
                contained *= -1;
            if (nums[contained-1] > 0)
                nums[contained-1] *= -1;
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > 0)
                disappeared.add(i+1);
        }
        return disappeared;
    }
}