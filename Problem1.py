# Time Complexity : O(n) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : 
"""
Approach

it is straight forward, we are using hashmap to keep track of the numbers and in every iteration we take the difference target adn the current num
and we check is the difference in in the hashmap we return the index of both the current number abd the num from the hashmap if not e just add the 
current num and index to hash map
"""

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [0,0]
        Hmap = dict()
        
        for index,num in enumerate(nums):
            remain = target - num
            if remain in Hmap:
                return [Hmap[remain],index]
            else:
                Hmap[num] = index