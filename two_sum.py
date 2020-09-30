#O(N) TIME AND O(N) SPACE WHERE N IS THE LENGTH OF NUMS ARRAY
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        encounterd_numbers = {}
        for i,num in enumerate(nums):
            difference = target - num
            if difference in encounterd_numbers:
                return [encounterd_numbers[difference],i]
            encounterd_numbers[num] = i
            