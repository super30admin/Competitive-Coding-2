// Leetcode link - https://leetcode.com/problems/two-sum/description/


// ******************** Brute Force Approach ********************
// Time Complexity: O(n)
// Spcae Complexity: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++)
        {
            int temp = target - nums[i];
            if(map.containsKey(temp))
            {
                ans[0] = map.get(temp);
                ans[1] = i ;
                break;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}

//// ******************** Brute Force Approach ********************
//// Time Complexity: O(n^2)
//// Spcae Complexity: O(1)
//
//class Solution
//{
//    public int[] twoSum(int[] nums, int target)
//    {
//        int answer[] = new int[2];
//        loop:
//        for(int i=0 ; i<nums.length-1 ; i++)
//        {
//            for(int j=i+1 ; j<nums.length ; j++)
//            {
//                if(nums[i]+nums[j]==target)
//                {
//                    answer[0] = i;
//                    answer[1] = j;
//                    break loop;
//                }
//            }
//        }
//        return answer;
//    }
//}
