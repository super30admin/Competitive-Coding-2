import java.util.Map;

import java.util.HashMap;

//Time complexity : O(n) We traverse the list containing nn elements only once. Each look up in the table costs only O(1)O(1) time.

//Space complexity : O(n) The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.

public class Problem1 {
    public static int[] twoSum(int[] nums, int target) {
    	//initilising array to store two  index of two numbers whose sum is target
        int[] results=new int[2]; 
        
        //Hashmap to store key as element of array and value as its index
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        //Iterate over loop to check otherelement= target-currrentelement present in array or not.
        for(int i=0;i<nums.length;i++)
        {
        	//if two elements present in an array then store index into result array otherwise store element and its index in a Hashmap
            if(map.containsKey(target-nums[i])){
                results[0]=map.get(target-nums[i]);
                results[1]=i;
                // return result
                return results;
            }
              map.put(nums[i],i); 
            
        }
       
        throw new IllegalArgumentException("No two sum solution");
  
    }
    
    public static void main(String[] args) {
    	int[] nums = {2,7,11,15};
    	int target = 9;
    	int[] result;
    	result = twoSum(nums, target);
    	System.out.println("index of first number is"+result[0]);
    	System.out.println("index of second number is"+result[1]);
    }

}
