//Accepted on LT
//Used hashmap and got time to O(n)


class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            int d = target-nums[i];
            if(hm.containsKey(d)){
                result[0] = hm.get(d);
                result[1] = i;

            }
            else{
                hm.put(nums[i],i);
            }
            

        }
        return result;

        
    }
}