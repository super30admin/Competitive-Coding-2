// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// set the value to the arrayList and check if the k - new values contians in the arralist, if yes then get the index of that and store it to the array which we need to return
// Your code here along with comments explaining your approach

/*
// using arraylist
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if( nums == null || nums.length == 0) return new int[0];
        ArrayList<Integer> sumValues = new ArrayList<>();
        int [] ans = new int [2];
        boolean hasValues = false;
        for( int i = 0; i< nums.length; i++){
            if( sumValues.contains(target - nums[i]) ){  // check if the sum already present
               ans[0] = sumValues.indexOf(target - nums[i]);
               ans[1] = i;
               hasValues = true;
               break;
            }else{
                sumValues.add(nums[i]);
            }
        }
        if(hasValues){ // check if there are any pair or not
            return ans;
        }else{
            return new int[0];
        }
    }
}
*/

// using hashMap
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if( nums == null || nums.length == 0) return new int[0];
        HashMap<Integer,Integer> sumValues = new HashMap<>();
        int [] ans = new int [2];
        boolean hasValues = false;
        for( int i = 0; i< nums.length; i++){
            if( sumValues.get(target - nums[i])  != null){  // check if the sum already present
                ans[0] = sumValues.get(target - nums[i]);
                ans[1] = i;
                hasValues = true;
                break;
            }else{
                sumValues.put(nums[i], i);
            }
        }
        if(hasValues){ // check if there are any pair or not
            return ans;
        }else{
            return new int[0];
        }
    }
}
