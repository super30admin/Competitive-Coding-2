import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSumHashing(int[] nums, int tar){

        HashMap<Integer, Integer> map = new HashMap<>(); // O(n)

        for(int i = 0; i < nums.length; i++){ // O(n)

            map.put(nums[i], i);
        }

        for( int i = 0; i < nums.length; i++){ // O(n)

            // complement
            int comp = tar - nums[i];

            if(map.containsKey(comp) && map.get(comp) != i){ // O(1)

                return new int[] {i, map.get(comp)};
            }
        }

        return new int[] {-1, -1};
    }

    /* Time Complexity = O(n) - two separate for loops and hashmap lookup in O(1)
       Space Complexity = O(n) as  hashmap is used
    */

    public static void main(String[] args){

        TwoSum object = new TwoSum();

        int[] arr = {2, 7, 11, 15};

        int target = 9;

        int[] result = object.twoSumHashing(arr, target);

        System.out.println("Two indices of numbers summing to give target are " + Arrays.toString(result));
    }
}
