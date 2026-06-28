'''
The solution is to find a matching number given to the current number.
Matching number for a current number is the one that produces the sum = target.

We keep a hashmap of the numbers visited before along with their index.
For the current number if we find the target - current number then we return 
indexes of the numbers.

Time complexity: O(n)
Space complexity: O(n)
'''
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hMap = {}
        for idx, i in enumerate(nums):
            if target - i in hMap:
                return [hMap[target-i], idx]
            hMap[i] = idx