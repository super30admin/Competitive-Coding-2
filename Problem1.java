    /*  Explanation
    # Leetcode problem link : NA
    Time Complexity for operators : o(n)
    Extra Space Complexity for operators : o(n) .. 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Two for loops. Check sum of element with its next elements in an array. If sum equals to target then return 
                            indexes from array. 

        # Optimized approach: . 
                              
            # 1. Defina hasmap. and calculate the complement.
            # 2. if the complelenent is part of hashmap that means we found the element with the target sum
            # 3. if not found then put element with its index.
            # 4. At the end, return {-1,-1} if sum is not found.
    */
import java.util.*;
    public class Problem1{
        public static void main(String args[]) {
                    int arr[]= new int[] {2,7,11,15};
                    int sum = 9;
                    int arr1[] = twoSum(arr,sum);
                    System.out.println(arr1[0]);
                    System.out.println(arr1[1]);
                }
                
                
        public static int[] twoSum(int[] nums, int target) {
            //brute force
                    // int result[] = new int[2]; 
                    // for(int i=0;i<nums.length-1;i++){
                    //     for(int j=1;j<nums.length;j++){
                    //     if(nums[i]+nums[j]==target && i!=j){
                    //         result[0] = i;
                    //         result[1] = j;
                    //         break;
                    //     }}
                    // }
                    // return result;

                    //optimized

                        HashMap<Integer,Integer> hm = new HashMap<>();
                        for(int i=0;i<nums.length;i++){
                            int diff = target - nums[i];
                            if(hm.containsKey(diff)){
                                return new int[]{hm.get(diff),i};
                            }
                            hm.put(nums[i],i);
                        }
                        return new int[]{-1,-1};
        }
    }