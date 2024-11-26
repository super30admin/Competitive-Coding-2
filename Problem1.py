from typing import List

"""

    Student : Shahreen Shahjahan Psyche
    Time Complexity : O(N)
    Space Complexity : O(N)

"""

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        # edge case
        if not nums:
            return []
        
        records = {}
        #output
        val = []
        
        # Checking whether the subtraction of target and my current index's value
        # is inside hash map or not. If it is then I am saving the value of the key
        # which repreesents the other value's index and current index in an array 
        # and breaking the loop
        for i in range(len(nums)): 
            if target - nums[i] not in records.keys():
                records[nums[i]] = i
            else:
                val.append(records[target-nums[i]])
                val.append(i)
                break
                
        return val
        
        
        
        
        
        
        

