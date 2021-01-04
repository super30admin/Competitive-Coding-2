import java.util.HashMap;

/*
 * Please find below Map solution. 
 * Complexity of the algorithm is O(n)
 * where n is the length of the array and to search in map we need O(1) time.
 */
public class TwoSum {
	
	  public static int[] twoSum(int[] nums, int target) {
	        
	        HashMap<Integer,Integer> map= new HashMap<>();
	        
	        for(int i=0;i< nums.length;i++){
	            
	            
	            map.put(nums[i],i);
	            
	        }
	        
	        for(int i=0;i< nums.length;i++){
	            
	            
	           int compliment= target- nums[i];
	            
	            if(map.containsKey(compliment) && map.get(compliment)!=i)
	                return new int[] {i, map.get(compliment)};
	            
	        }
	        
	        return new int[] {-1,-1};
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums= {2,7,11,15};
		int target = 9;
		
		System.out.println(twoSum(nums,target));
	}
	
	

}
