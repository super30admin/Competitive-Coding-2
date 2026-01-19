import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {


        int n=nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i],i);
            }
            else{
                return new int []{i,map.get(target-nums[i])};
            }


        }
        return new int []{-1,-1};
        
    }
}