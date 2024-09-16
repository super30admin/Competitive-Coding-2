# Time Complexity : O(N)
# Space Complexity : O(N) N - size of hashmap

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        h = {}
        # index, element
        for i, num in enumerate(nums):
            # complement
            n = target - num
            # if complement is not present in hashmap, add the <element, index> 
            if n not in h:
                print(n)
                h[num] = i
            # else, return the respective indeces
            else:
                print(n)
                return [h[n], i]
        return [-1, -1]