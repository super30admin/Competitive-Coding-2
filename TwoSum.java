import java.util.*;
/*
TC: O(N) N - length of array
SC: O(N) Hashmap may contain all N elements

1. We keep checking if (target - current element) exists in hashmap. It it exists, then current element and entry in map will sum to target.
2. Update the map in every iteration with current element and its index.
3. Return the result array by fetching index from map and index of current element.

*/

public class TwoSum{
    public int[] twoSum(int[] arr, int target){

        if(arr == null || arr.length == 0) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(target - arr[i])){
                return new int[]{map.get(target - arr[i]), i};
            }
            map.put(arr[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args){
        int[] arr = new int[]{2,11,15,7};
        TwoSum ts = new TwoSum();
        int[] res = ts.twoSum(arr, 9);

        System.out.println(res[0] +" "+ res[1]);
    }
}