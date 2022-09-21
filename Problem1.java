// Time Complexity : O(n)  n is size of array 
// space Complexity : O(n) because we are storing the values in HashMap

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int n = nums.length;
        
        HashMap<Integer,Integer> map= new HashMap<>();
        int[] a = new int[2];
        
        for(int i=0;i<nums.length;i++){
        
            int diff= target-nums[i];
            
            if(map.containsKey(diff)){
                a[0]= map.get(diff);
                a[1]= i;
               
            }
            else{
                map.put(nums[i],i);
            }
        }
        
        return a;
    }
}