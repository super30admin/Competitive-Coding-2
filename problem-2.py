# Leetcode Execution : YES
# Time COmplexity: O(n)
# Space Complexity: O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mapp={}
        list1=[]
        # we go with x+y=target formula and put target-nums[i] as key and val as i 
        # we then look for x which is equal to target-nums[i] in dict and the return the curretn index and index of x in dict 
        for i,x in enumerate(nums):
            if x not in mapp:
                mapp[target-x]=i
            else:
                return [i,mapp[x]]
        return -1