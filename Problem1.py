# Two Sums
# Time complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0 or nums == None:
            return []
        
        hashmap = {}
        result = []
        
        for i in range(len(nums)):
            if nums[i] in hashmap:
                result.append(hashmap[nums[i]])
                result.append(i)
                return result
            
            else:
                hashmap[target - nums[i]] = i
                
        return []

# In this approach, we check if the current element's difference with the target sum is present in the hashmap. If it is presetn, we return the indices of both elements,
# and if not present, we will store the current element in the hashmap as the element as key and it's index as the value.