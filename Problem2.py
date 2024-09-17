
class Solution:
    """
    Echasutive approach
    compare all type of combinations
    TC - O(n^2)
    SC - (O(n)
    """
    def approach1(self, nums, target):
        ans = []
        for i in range(0, len(nums)):
            for j in range(i + 1, len(nums)):
                a = nums[i]
                b = nums[j]
                if a + b == target:
                    ans.append(i)
                    ans.append(j)
                    return ans

    """
    Remaining approach
    Store the remaining in a dictionary and look for the new pair
    TC - O(n)
    SC - (O(n)
    """
    def approach2(self, nums, target):
        hp = dict()
        for i, val in enumerate(nums):
            remaining = target - val
            if remaining not in hp:
                hp[val] = i
            else:
                return [i, hp[remaining]]

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        return self.approach2(nums, target)

