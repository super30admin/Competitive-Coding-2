/*
Time Complexity -->
O(n)

Space Complexity -->
O(n)
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int arr[] =new int[2];
        for(int i=0;i<nums.length;i++){
            
            sum = target-nums[i];
            if(map.containsKey(sum)){
                arr[0] = map.get(sum);
                arr[1] = i;
                break;
            }//if
            else{
                map.put(nums[i], i);
                
            }//
            
            
        }//for
        
        return arr;
        
        
    }
}