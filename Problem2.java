// Two Sum Find Indices
import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        /* brute force TC=O(n^2) SC=O(1)*/
        /* int[] indices = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return new int[]{0,0}; */

        /* two pointer approach -- TC=O(nlogn) SC=O(1)
        Sort and shift the pointers based on greater or less than sum*/
        /* HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        Arrays.sort(nums);
        int left = 0; int right = nums.length - 1; int[] result = new int[]{-1,-1};
        while(left <= right){
            if(nums[left]+nums[right]<target){
                // means we need sum to increase hence move left pointer as sorted array will have 
                // greater elements towards right
                left++;
            }else if(nums[left]+nums[right]>target){
                right--;
            }else if(nums[left]+nums[right]==target){
                //means its equal to target
                result[0] = left;
                result[1] = right;
                break;
            }
        }
        return result; */

        /* HashSet Solution TC=O(n) SC=O(n)*/
        HashMap<Integer,Integer> myMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            // check if the complement of current element is present in the hashset
            // Search is O(1) hence try finding target - currentElement
            if(myMap.containsKey(target-nums[i])){
                return new int[]{myMap.get(target-nums[i]),i};
            }else{
                myMap.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}