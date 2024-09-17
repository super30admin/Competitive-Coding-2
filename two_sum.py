# // Time Complexity : O(n) where n is the number of elements
# // Space Complexity : O(n) where n is the number of elements
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = defaultdict(int)
        
        for i in range(len(nums)):
            if target-nums[i] in hashmap:
                index = hashmap[target-nums[i]]
                return [index,i]
            hashmap[nums[i]] = i
        return [-1,-1]
