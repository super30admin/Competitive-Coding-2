//Time Complexity - O(n)
//Space Complexity - O(n)

// Iterate over an array calculate sum= element - target, check if dictionary contains sum , if not then add element and its index in dictionary.

// If the sum is in the dictionary then return index stored at the sum and current index.

public class Solution
{
    public int[] TwoSum(int[] nums, int target)
    {
        //Dictionaries O(n)
        var pairs = new Dictionary<int, int>();
        int sum = 0;
        for (int i = 0; i < nums.Length; i++)
        {
            sum = target - nums[i];
            if (pairs.ContainsKey(sum))
                return new int[] { pairs[sum], i };
            else
                pairs.TryAdd(nums[i], i);
        }
        return default;
    }
}



