/*
Time Complexity: O(N)
Space Complexity: O(1)
*/
import java.util.*;
class Solution {
    public int maxSubArray(int[] nums) {
    int i=0;
    int rsum=0;
    int max=Integer.MIN_VALUE;
    int maxsum=0;
    while(i<nums.length){
        if(rsum<0&&nums[i]>0){
            rsum=0;
        }
        if(max<nums[i]){
            max=nums[i];
        }
        rsum+=nums[i];
        if(maxsum<rsum){
            maxsum=rsum;
        }
        i++;
    }
    if(maxsum==0){
        return max;
    }
    return maxsum;
    }
}