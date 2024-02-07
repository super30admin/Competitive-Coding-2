import java.util.HashMap;
//Time Complexity: O(n)
//Space Complexity: O(n)
 public class sumOfTwoIntegers_returnIndex {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        //build the hashmap
        for (int i=0; i<n; i++){
            hm.put(nums[i],i);
        }
        //logic
        for (int i=0; i<n; i++){
            int comp = target-nums[i];
            if (hm.containsKey(comp) && hm.get(comp)!=i){
                return new int[]{i,hm.get(comp)};
            }
        }
        return new int[]{};
    }
}