// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :no
// Any problem you faced while coding this :no
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> iMap=new HashMap<>();
	
	for(int i = 0;i<nums.length;i++) {
		
			iMap.put(nums[i],i);
	
    }
        for(int j =0;j<nums.length;j++){
           int x= target-nums[j];
            if(iMap.containsKey(x) && iMap.get(x) != j){
                return new int []{j,iMap.get(x)};
            }
			
        }		
	

	return new int []  {0};

        
    }
}