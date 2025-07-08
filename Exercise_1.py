# Time Complexity: O(n)
# Space Complexity: O(n)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: The dry running of 
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        if not nums:
            return [-1,-1]
        
        
        # Using a hashmap to store the indices of the numbers
        nmap = {}

        for i in range(len(nums)):
            
            # Check if the complement (target - nums[i]) exists in the hashmap
            # If it exists, return the indices of the two numbers
            # If it does not exist, store the current number and its index in the hashmap
            if nmap.get( target-nums[i], None) is not None:

                return [nmap[target-nums[i]], i]
            else:

                nmap[nums[i]] = i
        
        