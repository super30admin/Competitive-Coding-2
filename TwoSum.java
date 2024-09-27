// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// To find the target number, we require two numbers -> a + b
// We keep a track of the number (a) that we are currently pointed to in the array in hashmap.
// Before updating the map, we check if number (b) is already available in the map.
//      If yes, then we return the indexes of a and b.
// If we don't find the pair in the map, then we return the default pair of indexes.

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoNumberSum(int[] input, int target){
        if(input == null || input.length == 0) return new int[]{-1, -1};

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < input.length; i++){
            map.put(input[i], i);
            if(map.containsKey(target-input[i])){
                return new int[]{i, map.get(target-input[i])};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] input = {3,2,6,8,9,1,0,5};
        int[] result = twoNumberSum(input, 7);
        System.out.println(result[0]+", "+result[1]);
    }
}