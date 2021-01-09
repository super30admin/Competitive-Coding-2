# To find indices of 2 numbers from a given array which meet the target value

class Solution:
    
    def twoSum(self, nums: List[int], target: int) -> List[int]:
    
        """
        - Use dictionary to store indices for each number progressively
        - stop when index of already present number (as key) and current number matches the target
        - return indices from the dictionary and current index
        """
    
        num_dict = {}
        for i in range(len(nums)):
            rem = target - nums[i]
            if not rem in num_dict.keys():
                num_dict[nums[i]] = i
            else:
                return [num_dict[rem], i]
        else:
            return [-1, -1]
