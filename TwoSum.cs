//Time: O(n)
//Space: O(n)
//Leetcode: https://leetcode.com/submissions/detail/575536540/

using System;

namespace twoSum
{   

    public int[] TwoSum(int[] nums, int target) {
        
        int[] result = new int[2];
        Dictionary<int, int> dict = new Dictionary<int, int>();
        
        for(int i =0; i< nums.Length; i++) {
            int complement = target - nums[i];
            if(dict.ContainsKey(complement)) {
                result[1] = i;
                result[0] = dict[complement];
            } else {
                if(! dict.ContainsKey(nums[i]))
                    dict.Add(nums[i], i);
            }            
        }
        return result;
    }

    class Program
    {
        static void Main(string[] args)
        {
            
            Console.WriteLine("Hello World!");
        }
    }
}
