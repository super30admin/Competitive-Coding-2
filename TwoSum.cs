public class Solution
{
    public int[] TwoSum(int[] nums, int target)
    {
        Dictionary<int, int> lookup = new();
        for (int i = 0; i < nums.Length; i++)
        {
            var diff = target - nums[i];
            if (lookup.ContainsKey(diff))
            {
                return new int[2] { lookup[diff], i };
            }
            lookup.TryAdd(nums[i], i);
        }
        return null;
    }
}