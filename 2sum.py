class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        freqMap = defaultdict(list)

        for idx, value in enumerate(nums):
            freqMap[value].append(idx)

        for idx, num in enumerate(nums):
            if target - num in freqMap:
                indexes = freqMap[target - num]
                for i2 in indexes:
                    if i2 != idx:
                        return [idx, i2]
