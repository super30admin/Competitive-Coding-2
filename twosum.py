from typing import List


class Solution(object):
    def sumtwo(self, nums: List[int], target: int):
        # init a hashmap
        myHashMap = {}
        # loops the range length of nums array: range(5) -> 0,1,2,3,4
        for i in range(len(nums)):
            # if subtraction is already available in hashmap return the 
            # current index and value (index) of the key in the index
            if target-nums[i]in myHashMap:
                return [i, myHashMap[target-nums[i]]]
            else: 
                # add element with index in the hashmap
                myHashMap[nums[i]] = i
        # if not match found then return -1,-1 list
        return [-1,-1]

sol = Solution()
print(sol.sumtwo([2,7,6,3,5], 5))