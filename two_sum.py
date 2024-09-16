# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        _dict = {}
        for i in range(len(nums)):
            _rem = target - nums[i]
            if _rem not in _dict:
                _dict[target - _rem] = i
            else:
                return [_dict[_rem], i]


if __name__ == '__main__':
    _arr = [2, 8, 10, 15, 19]
    _target = 12
    print(Solution().twoSum(_arr, _target))

