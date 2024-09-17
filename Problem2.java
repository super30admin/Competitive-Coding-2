class Solution {
    public int[] twoSum(int[] nums, int sum) {
      //two pass hashmap
      int[] res = new int[2];
      HashMap<Integer,Integer> hm = new HashMap();
      for(int i=0;i<nums.length;i++){
        hm.put(nums[i],i);
      }
      
      
      for(int i=0;i<nums.length;i++){
        if(hm.containsKey(sum - nums[i]) && (hm.get(sum - nums[i]))!= i ){
            res = new int[]{i,hm.get(sum - nums[i])};
          
        }
      }
   
      return res;
    }
}
