/* Successfully executed on leetcode
*  Time Complexity: In worst case we might have to traverse through entire array so O(n)
*  Space Complexity: Here hashmap is used to store number and it's index. In worst case we might have to
*                    store almost entire in the map. So O(n)
*
*  Approach: Iterate over entire array, for every iteration,
*            Find difference of target and number at current index. If the difference is found
*            in hashmap return fetch index index of the element from hashmap and return both indices
*            If difference is not found store the element and it's index.
*
* */
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String args[]){
        int n[] = {2,7,11,15};
        int target = 9;
        for(int a: twoSum(n, target))
            System.out.print(a+" ");
    }

    public static int[] twoSum(int[] nums, int target){
        int[] targetArray = new int[2];
        Map<Integer, Integer> twoSumMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(twoSumMap.containsKey(diff)) {
                targetArray[0] = twoSumMap.get(diff);
                targetArray[1] = i;
                break;
            }else{
                twoSumMap.put(nums[i], i);
            }
        }
        return targetArray;
    }
}
