# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = collections.defaultdict(int)
        for i in range(len(nums)):
            if dic:
                if (nums[i]) in dic:
                    return [dic[nums[i]], i]
            dic[target - nums[i]] = i

