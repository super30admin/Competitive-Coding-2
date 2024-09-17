
'''
time = O(n)

space - O(n) - hashmap for number of elements in the list

Able to run in leet code -- yes

Faced any probem - No

Method - Create a hash map. calculate complement (complement = target - current number in loop). If the complement exists in hash map, return complement and the current number. If the complement doesnot exist in map, add the number to the map and continue the for loop until complement is found
'''

from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        
        for i in range(len(nums)):
            complement = target - nums[i]
            if(map.__contains__(complement)):
                return [map[complement],i]
            else:
                map[nums[i]] = i
        



sol = Solution()
nums = [3,2,4]
target = 0
print(sol.twoSum(nums,target))