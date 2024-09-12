//Time Complexity: O(N)
//Space Complexity:O(N)
public class sol {
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer,Integer> hs = new HashMap<>();
		for(int i =0; i<nums.length; i++) {
			hs.put(nums[i],i);
		}
		for(int i=0;i<nums.length;i++) {
			int compliment = target - nums[i];
			if(hs.containsKey(compliment) && hs.get(compliment)!=i) {
				return new int[] {i,hs.get(compliment)};
			}
		}return new int[] {-1,-1};
	}
	
public static void main(String[] args) {
	int arr[] = {2,7,11,15};
	int target = 9;
	
	System.out.println(Arrays.toString(twoSum(arr, target)));
}
}
