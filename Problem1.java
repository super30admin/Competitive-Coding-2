class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n= nums.length;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0; i<n;i++){
            int compliment= target-nums[i];
            if(map.containsKey(compliment)){
                return new int []{i,map.get(compliment)};
                
            }
            else{
                map.put(nums[i], i);
            }
        }
        return new int[] {-1,-1};
    }
}