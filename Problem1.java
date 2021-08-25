//Time Complexity:O(N^2)
//Space Complexity:0(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int firstPointer=0,secondPointer=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                 if(nums[i]+nums[j]==target){
                     return new int[]{i,j};
                 }
                }
            }
        }
        return new int[]{-1,-1};
    }
}
//Time Complexity:O(N)
//Space Complexity: O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int firstPointer=-1,secondPointer=-1;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]) && i!=map.get(target-nums[i])){
               firstPointer=i;secondPointer=map.get(target-nums[i]);
                break;
                }
            }
        return new int[]{firstPointer,secondPointer};
}
}