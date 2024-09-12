class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dataStore = dict()
        i = 0
        for n in nums:
            if n in dataStore:
                return [dataStore[n], i]
            else:
                dataStore[target-n] = i
                i+=1
