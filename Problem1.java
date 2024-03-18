class Solution {
    public int[] twoSum(int[] nums, int target) {
    HashMap <Integer, Integer> map = new HashMap<>();
    for(int i = 0; i< nums.length; i++){
    int temp = target - nums[i];
    if(map.containsKey(temp)){
    return new int[] {map.get(temp),i};
    }
    map.put(nums[i],i);
    }
    return new int[]{};
    }
    }
    
    // //brute force approach
    // int[] arr = {-1,-1};
    // for(int i = 0; i< nums.length; i++){
    // for(int j =i+1; j< nums.length; j++){
    // if(target - nums[i] == nums[j]){
    // arr[0] = i;
    // arr[1] = j;
    // break;
    // }
    // }
    // }
    // return arr;