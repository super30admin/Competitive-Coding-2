'''
    Time Complexity:
        O(n)

    Space Complexity:
        O(n)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        HashMap approach
'''
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dct = {}
        for i, num in enumerate(nums):
            diff = target - num
            if diff in dct:
                return [i, dct[diff]]

            dct[num] = i

        return [-1, -1]
