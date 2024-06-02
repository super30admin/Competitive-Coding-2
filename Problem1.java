//Time Complexity - O(n)
//Space Complexity - O(n)
//Approach - Iterate over each element and calculate the sum - the element value. Check if it is already present in the hashmap. 
// If yes, store the indices in an array and return it. 
//If not, add the entry with the index to the map. 
import java.util.*;
public class Problem1 {
    static int[] twoSum(int[] nums, int sum){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(sum - nums[i])){
                return new int[] {map.get(sum - nums[i]), i};
            }
            map.put(nums[i],i);
        }

    return new int[] {};
    }

public static void main(String[] args){
    int[] nums = {3,4,5,7,2};
    int sum = 7;
    int [] result = twoSum(nums,sum);
    System.out.println(Arrays.toString(result));
    }
}