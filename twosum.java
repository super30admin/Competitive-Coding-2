class Solution {
    public int[] twoSum(int[] nums, int target) {
    //tc: O(n), sc:O(n)
     int[] result=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0]=i;
                result[1]=map.get(target-nums[i]);
        }
         map.put(nums[i],i);}
        return result;
    }
}
