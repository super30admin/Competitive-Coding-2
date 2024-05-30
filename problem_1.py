# Two sum problem 

# Time O(n)
# Space O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mem = {} # S = O(N)
        # T = O(N)
        for i, num in enumerate(nums):  # [2,7,11,15]
            res = target - num  # 7
            if res in mem: 
                return [i, mem[res]]
            mem[num] = i # {2: 0, } 
        return []
        

        