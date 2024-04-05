//1. Two Sum
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] op = new int[2];
        for( int i=0; i<nums.length; i++){
            int temp = target-nums[i];
            for (int j=i+1; j<nums.length; j++){
                if(nums[j]==temp){
                    op[0]=i;
                    op[1]=j;
                    break;
                }
            }
        }
        return op;
    }
}
