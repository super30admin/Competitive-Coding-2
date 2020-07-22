// Time Complexity : O(n)
// Space Complexity : O(n) , worst case we have to store everything

//Approach
//1. Traverse through each element
//2. Check if target-element is present in HashMap 
//3. if present(target-element) then we found the both elements
//4. else put in map (element, index)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                res[0] = i;
                res[1] = map.get(comp);
                break;
            }else{
                map.put(nums[i], i);
            }
        }
        return res;
    }
}