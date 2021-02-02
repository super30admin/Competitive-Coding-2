# O(N) TIME AND O(N) SPACE WHERE N IS LEN(NUMS)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        complements = {}
        for i,num in enumerate(nums):
            diff = target - num
            if diff in complements:
                return [i,complements[diff]]
            complements[num] = i
        return []
                
        