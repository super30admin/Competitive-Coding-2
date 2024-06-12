/**

 nums    2 7 11 15  
 target  9
 result  [0, 1]
 
 - negative
 - duplicates
 - one valid answer 
 
 2 
 target - 9-2 = 7
 
 BruteForce
 Tc - n-1 * (n-2) O(n^2)
 SC - O(1)
 
 Optimal
 O(n)
 O(n)
 
 Map 
 2 -> 0
 
 [2,7,11,-7]
  0
  
  2->1
  7 -> 2

**/

class Solution {
    
    final Map<Integer, Integer> elementToIndex = new HashMap<>();
    
    public int[] twoSum(int[] nums, int target) {
        
        int result[] = new int[2];
        
        for (int i=0; i<nums.length; i++)
        {
            int remainingTarget = target - nums[i];
            
            if (elementToIndex.containsKey(remainingTarget))
            {
                result[0] = elementToIndex.get(remainingTarget);
                result[1] = i;
                
                return result;
            }
            
            elementToIndex.put(nums[i], i);
        }
        
        return result;
    }
}