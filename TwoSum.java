import java.util.HashMap;

public class TwoSum {
	
	public int[] TwoSumm(int[] nums, int target) {
		
		if(nums.length==0)
			return new int[] {-1, -1};
		
		HashMap<Integer, Integer> mapNo = new HashMap();
		
		for(int i=0;i<nums.length;i++) {
			
			int diff = target - nums[i];
			
			if(!mapNo.containsKey(diff))
			{
				mapNo.put(nums[i], i);
			}else {
				return new int[] {mapNo.get(diff), i};
			}
		}
		return new int[] {-1, -1};
	}

	public static void main(String[] args) {
		TwoSum tw = new TwoSum();
		int[] nums = {2, 7, 11, 15};
		int[] res = tw.TwoSumm(nums, 9);
		System.out.println(res[0]+" "+ res[1]);
	}
}
