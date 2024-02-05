// TC - O(n)
//SC - O(n)
//Ran in LC - Yes
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){ //O(n)
            int find = target - nums[i];
            if(map.containsKey(find)) //O(1)
                return new int[]{map.get(find), i};
            else
                map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] output = twoSum(nums, target);
		System.out.println(Arrays.toString(output));
	}
}
