#Time Complexity O(N) Linear
#Space Complexity O(N) hashmap
#It successfully runs on leetcode

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        ans=dict()
        for i in range(len(nums)):
            if nums[i] in ans:
                return [ans[nums[i]], i]
            else:
                ans[target-nums[i]] = i

    
