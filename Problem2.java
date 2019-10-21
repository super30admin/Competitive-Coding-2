//Two Sum
//Method-1 Brute Force Solution (Use 2 pointers)
//Solution ran successfully in leetcode
//Time Complexity- O(n^2)(We iterate through the array twice since we use 2 pointers)
//Space Complexity-O[1]( Since a constant space array of size 2 is used)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(target==nums[i]+nums[j]){
                    arr[0]=i;
                    arr[1]=j;
                }
            }
        }
        return arr;
    }
}
//Method-2 Using a hashmap
//Solution ran successfully in leetcode
//Time complexity-O(n^2)(We iterate through the array twice once for loading the elements into the hashmap another for finding the compliment of the element)
//Space Complexity-O(n)(Since we construct an hashmap of the size of the array)
class Solution {
    public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> result = new HashMap<>();
    //Loading all the elements and its corresponding indexes to hashmap
    for (int i = 0; i < nums.length; i++) {
        result.put(nums[i], i);
    }
    //Finding the differences of elements
    for (int i = 0; i < nums.length; i++) {
        int dif = target - nums[i];
        //Checking if the differences exists in hashmap and is not the same as the element considered
        if (result.containsKey(dif) && result.get(dif) != i) {
            return new int[] { i, result.get(dif) };
        }
    }
    //If no such numbers exists an array of -1,-1 is returned
     return new int[] {-1,-1};
}
}
//Doubts with respect to this question
// 1. While using the hashmap, the time complexity remains the same as we go through the array twice, once to load the elements in the array to hashmap and second time to find the differences.
// The space complexity also increases from O[1] to O[N], so is 2 pointers the optimal solution for this problem?
// 2. If the two numbers doesn't exists , I am returning an array of -1 but is it what we should be doing?