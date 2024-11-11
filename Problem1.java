// Approach : With a map in one pass by storing nums and index but checking for comp before filling the map.
// We wont have that edge case of comp present in the map  at the same index of num
// Time : O(n) + O(n)
// Space : O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n= nums.length;
        for(int i=0;i<n;i++){
            int comp = target-nums[i];
            if(map.containsKey(comp)){
                return new int[]{i,map.get(comp)};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};

    }
}

// Approach : With a map in two pass
// Time : O(n) + O(n)
// Space : O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n= nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],i);            
        } 

        for(int i=0;i<n;i++){
            int comp = target-nums[i];
            if(map.containsKey(comp) && map.get(comp)!=i){
                return new int[]{i,map.get(comp)};
            }
        }
        return new int[]{-1,-1};

    }
}