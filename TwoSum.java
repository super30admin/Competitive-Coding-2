package CompetitiveCoding2;
//TC: O(n)
//SC:O(n)
//Approach : put all elements in map with its index, find complement and lookup in map
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,7,11,15};
		int target = 9;
		
		int[] result = twoSumSolution(nums,target);
		
		System.out.println(Arrays.toString(result));
		
	}

	private static int[] twoSumSolution(int[] nums, int target) {
		// TODO Auto-generated method stub
		int[] result = new int[2];		
	    HashMap<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	        	result[0] = map.get(complement);
	        	result[1] = i;
	        	return result;
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}

}
