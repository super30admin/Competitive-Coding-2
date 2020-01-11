import java.util.HashMap;
// Time complexity is O(n) as one loop is used for filling hashmap and other for searching which is O(1)
// Space complexity is O(n) as we are using additional hashmap
// this solution is submitted on Leetcode
public class TwoSumOnSolutionBigN28 {
	public int[] twoSum(int[] nums, int target) {
		//Edge Case
		if (nums== null || nums.length==0)
			return new int [] {};
		HashMap<Integer,Integer> map = new HashMap<>();
		int len = nums.length;
		for (int i =0;i<len;i++) {
			map.put(nums[i],i);
		}
		for(int i = 0;i<len;i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement) && map.get(complement)!=i) {
				return new int [] {i,map.get(complement)};
			}
		}
		return new int[] {-1,-1};
	}
	
	public static void main(String args[]) {
		TwoSumOnSolutionBigN28 tSum = new TwoSumOnSolutionBigN28();
		int target = 9;
		int [] nums = {2, 7, 11, 15};
		for (int i :tSum.twoSum(nums, target))System.out.println(i);	
	}
}
