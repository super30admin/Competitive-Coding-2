class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        # Create an empty dictionary
        # Update dictionary as {value of the list: index in the list}
        nums_dict = {}
        
        # Iterate through the array, if the difference in the list, retrieve the element
        # If difference not in the list, append {value of the list: index in the list}
        
        for i in range(0,len(nums)):
            difference= target - nums[i]
            
            if difference in nums_dict:
                return [i,nums_dict[difference]]
            else:
                nums_dict.update({nums[i]:i})
        