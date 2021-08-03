#two sum
#solution accepted
#time complexity: O(n) where n is the size of array
#space complexity:O(n) since we initalize a hashmap
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums)<2:
            return False
        aux_dict = {} #using hashmap for solution
        for i in range(len(nums)):
            if nums[i] in aux_dict: #checking if nums[i] already exist in the solution 
                return aux_dict[nums[i]],i
            else:
                aux_dict[target-nums[i]]=i #if not target - the element is set to index 
