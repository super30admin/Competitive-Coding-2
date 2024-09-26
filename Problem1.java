//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public int[] twoSum(int[] nums, int target) {
     //Idea is to store the array in the hashmap and check if the second number is present in the hashmap by using the equation z = x + y
    	//if target - nums[i] is present, then that is the second number. 
        int[] indexs = new int[2];
	
	HashMap<Integer,Integer> m1 = new HashMap<>();

	for(int i = 0; i < nums.length; i ++){
	
	m1.put(nums[i],i);
        
    }
        System.out.print(m1);
		int temp = 0;
	for(int i = 0; i < nums.length; i ++){
	
		temp = target - nums[i];
		
		if(m1.containsKey(temp) ){
            
            if(m1.get(temp)!= i){
                
        indexs[1] = m1.get(temp);
		indexs[0] = i;
		return indexs;
            }
        }
		
		

	
	}
	return indexs;
		}
        
}
