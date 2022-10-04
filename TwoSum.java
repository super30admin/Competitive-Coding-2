//BruteForce

//TimeComplexity O(n^2)
//SpaceComplexity O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0 ; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {};
    }
}

//HashMap

//Timecomplexity O(n)
//SpaceComplexity O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[] {i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }

        return new int[] {};
    }
}
