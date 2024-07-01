import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int arr[]={-1,-1};
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        } 


        for(int i=0;i<nums.length;i++){
            int res = target-nums[i];
            if(map.containsKey(res) && map.get(res) != i){
                arr[0]=i;
                arr[1]=map.get(res);
            }
        }
        return arr;
    }
}