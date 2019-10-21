# Time complexity -O(N)
# Approach - using hash_map 

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hash_map={}
        for i in range(len(nums)):
            if nums[i] in hash_map:
                return[hash_map[nums[i]],i]
            else:
                a= target -nums[i]
                hash_map[a]=i



#Brute-force solution
#time complexity -O(N^2)


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
       
        for i in range(len(nums)):
            for j in range(i+1,len(nums)):
                if nums[i]+nums[j]==target:
                    return[i,j]
                    