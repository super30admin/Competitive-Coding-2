# Time Complexity : Add - O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes.

# Any problem you faced while coding this : No

'''
1. Given a target formed by two ekements x, y. I I know x, I can modify the problem statement tp -"If I have x, I need to search for target - x"

2. To imitate the same concept I am checking if each elemnt's complement is present in hashmap or not. If it is, we have found the constituent elements that make up the target.

3. The hashmap stores the the key as the elements as we iterate and since we need indices to retuen , the values will be the corresponding indices a element occured.
'''

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        if len(nums) < 2:
            return
        
        hashmap = {}
        for i in range(len(nums)):
            
            compliment = target - nums[i]
            
            if compliment in hashmap:
                return [hashmap[compliment], i]
                
            else:
                hashmap[nums[i]] = i
                
        return [-1, -1]
                
            