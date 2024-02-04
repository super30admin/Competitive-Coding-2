import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {

         // return helperBruteForce(nums, target);
        
         return helper1PassHashMap(nums, target);
    }

    public int[] helperBruteForce(int[] nums, int target) {
        int n = nums.length;
        int ans[] = null;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return ans = new int[] { i, j };
                }
            }
        }
        return ans;
    }

    public int[] helper1PassHashMap(int[] nums, int target) {
        int ans[] = null;
        int n = nums.length;
        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int key = nums[i];
            int complement = target - key;

            if (hmap.containsKey(key)) {
                return ans = new int[] { i, hmap.get(key) };
            } else {
                hmap.put(complement, i);
            }
        }
        return ans;
    }
}