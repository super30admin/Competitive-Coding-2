class TwoSum {

  /**
   * 
   * Time Compelxity: O(n)
   * Space Complexity: O(n)
   * 
   * Were you able to solve this on leetcode? Yes
   * Any issues solving this problem? No
   */
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    
    
    for(int i = 0; i < nums.length; i++){
        
        int currVal = nums[i];
        int targetVal = target - currVal;
        
        if(map.containsKey(targetVal)){
            return new int[] {i, map.get(targetVal)};
        }
        
        map.put(currVal, i);
    }
    
    return new int[2];
  }
}