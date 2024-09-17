class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        complement_map = {}
        
        for index, num in enumerate(nums):
            complement = target - num            
            # If complement was encountered before, we found a pair
            if complement in complement_map:
                return [complement_map[complement], index]

            # Store num with its corresponding index for complement lookup.
            complement_map[num] = index
        
        return [-1,-1]

### Complexity Analysis:
# Time Complexity: O(N) --> Iterating through the entire array once
# Space Complexity: O(N) --> Space occupied by hashmap