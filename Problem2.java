//Question: Delete and earn
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i], max);
        }
        int arr[] = new int[max+1];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]] +=nums[i];
        }
        int dp[] = new int[max+1];
        if(arr.length==2){
            return arr[1];
        }
        dp[1] = arr[1];
        dp[2] = Math.max(dp[1], arr[2]);
        for(int i=3;i<arr.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
        }
        return dp[arr.length-1];
    }
}