#timecomplexity = O(n)
#Space Complexity = O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hMap.put(nums[i],i);
        }
        //int[] arr = new int[2];
        for(int i=0;i<nums.length;i++){
            int rem = target - nums[i];
            if(hMap.containsKey(rem) && hMap.get(rem)!= i){
               // arr[0] = i;
                //arr[1] = hMap.get(rem);
                return new int[] {i, hMap.get(rem)};
            }
        }
        return null;
    }
}
