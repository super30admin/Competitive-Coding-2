# TC : O(n) ; n = length of nums array
# SC :  O(n) ; stores atmost n elements
# Approach : We use a hashmap to store the compliment and its index, if its not there already. When we find it in
# the hashmap means we found the two numbers, we return its value and current index, which are our target indexes.

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if(len(nums) <= 1):
            return []
        dc = {}
        for i in range(len(nums)):
            if nums[i] in dc:
                return(dc[nums[i]], i)
            else:
                dc[target-nums[i]] = i