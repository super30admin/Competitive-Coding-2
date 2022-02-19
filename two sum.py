# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        
        # elements as keys and indicies as values in hashmap
        for i in range(len(nums)):
            hashmap[nums[i]] = i
            
        # if complement of target and nums[i] in hashmap return i and complemets value
        for i in range(len(nums)):
            comp = target - nums[i]
            if comp in hashmap and hashmap[comp] != i:
                return [i, hashmap[comp]]
        