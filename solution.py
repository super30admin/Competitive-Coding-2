class Solution:
   # TC -  O(n) 
    # SC - O(n)  
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # map to store val, its index
        indexMap = {}

        # Iterate the array 
        for i in range(len(nums)):
            complement = target - nums[i]
            # Check if its there in map
            if complement in indexMap:
                return [i,indexMap[complement]]
            indexMap[nums[i]] = i  

       

        
