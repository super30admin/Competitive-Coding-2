//Two SumProblem


/*
time complexity - O(n)
space complexity - O(n)  //because of use of hashmap
*/
import java.util.*;
class Problem2{
    public static void main(String[] args) {
        //test case1
        int[] inputArr = {2,7,11,15};
        //taest case2
        int[] inputArr2 = {3,2,4};
        int target = 9;
        int target2 = 6;
        int[] res = twoSum(inputArr2, target2);
        System.out.println(res[0] +" "+res[1]);



    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target- nums[i]))
                return new int[] {map.get(target-nums[i]), i};
            map.put(nums[i], i);
        }
        
        return new int[]{-1, -1};
        
    }
}