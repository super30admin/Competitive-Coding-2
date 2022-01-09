import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return new int[2];
        int [] result= new int[2];
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int sum= copy[low]+copy[high];
            if(sum==target){
                break;
            }
             else if(sum>target)
                 high--;
            else
                low++;
        }
        
        //System.out.println(copy[low]);
        //System.out.println(copy[high]);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==copy[low])
                result[0]=i;         
        }
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j]==copy[high])
                result[1]=j;
        }
        return result;
    }
}