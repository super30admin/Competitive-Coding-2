# Time complexity: O(n)
# Space complexity: O(n)
# Approach: use hashmap to store element and index
# whenever we get a difference of visited value and target in hashmap, return it




class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        ans={}
        for i in range(len(nums)):
            if target-nums[i] in ans:
                return [ans[target-nums[i]],i]
            else:
                        ans[nums[i]]=i
        
        
        