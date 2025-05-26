#Time Complexity: O(N)
#Space Complexity: O(N)
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        hash_dict = {}

        for i in range(len(nums)):
            rem = target - nums[i]
            if rem not in hash_dict:
                hash_dict[nums[i]] = i
            else:
                print(hash_dict)
                #res_index = hash_dict[nums[i]]
                return [i,hash_dict[rem]]
        return []
        
