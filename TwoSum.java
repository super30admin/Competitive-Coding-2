import java.util.Arrays;
import java.util.HashMap;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int[] res = new int[2];

        for(int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if(!hmap.containsKey(nums[i])) hmap.put(nums[i],i);
            if(hmap.containsKey(diff) && hmap.get(diff) != i) {
                res[0] = hmap.get(diff);
                res[1] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,2,7,5,8,10};
        int target = 9;
        System.out.println("The indices which total to " + target + " from nums are "
                + Arrays.toString(twoSum(nums, target)));
    }
}