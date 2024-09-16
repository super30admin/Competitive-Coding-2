class Solution {
    public int[] twoSum(int[] nums, int target) {
      //map the element with indices
        Map<Integer,Integer> m=new HashMap<>();
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            if( m.containsKey(target-nums[i])){
              result[0]=i;
              result[1]=m.get(target-nums[i]);
                return result;
            }
            m.put(nums[i],i);
        }
      
      //return the array  
      return result; 
    }
}
//Time complexity: O(n) n is the length of the input array`
