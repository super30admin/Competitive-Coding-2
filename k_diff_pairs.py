class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        res = set()
        n = len(nums)
        i = 0
        j = 1
        nums.sort()
        while j < n:
            if nums[j] - nums[i] == k:
                res.add((nums[i], nums[j]))
                i = i + 1
                j = i+1
            elif nums[j]-nums[i] > k:
                i = i + 1
                j = i+1
            else:
                j += 1

        return len(res)
