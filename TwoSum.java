// Here I am using binary search so that we will have TC = n log(n)  and SC = O(1)

class TwoSum{
    public int[] twoSum(int[] nums, int target){
        Arrays.sort(nums);
        int res[] = new int[2];
        int n = nums.length;
        //int comp = target - nums[i];
        int low = 0;
        int high = n-1;

        for(int i = 0; i<nums.length; i++){
            int mid = low + (high-low)/2;
            int comp = target - nums[i];
            if(nums[mid] == comp) {
                res[0] = i;
                res[1] = mid;
            }
            else if(comp<mid){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

    }
}