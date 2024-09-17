//Time complexity - O(n)
//Space complexity - O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //null case 
      if(nums == null || nums.length == 0) {
        return new int[] {-1,-1};
      }
      //map
      HashMap<Integer,Integer> map = new HashMap<>();
      
      //if the difference  between target- currrent index
      for(int i = 0; i< nums.length;i++) {
        int difference = target - nums[i];
        
        //if the difference exist, then get the diff index and current index. 
        if(map.containsKey(difference)) {
          
          return new int[] {map.get(difference),i};
        }
        // put the diff in map
        map.put(nums[i] , i);
        
      }
      return new int[]{-1,-1};
    }
}