# Two sum

#tc: O(n)
#sc: O(n)

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # ans = []
        # for i in range(len(nums)-1):
        #     for j in range(i+1,len(nums)):
        #         if(nums[i]+nums[j] == target):
        #             ans.append(i)
        #             ans.append(j)
        #             return ans
        
        dictionary = {}
        for i in range(len(nums)):
            x = target - nums[i]
            if(x in dictionary):
                return [i,nums.index(x)]
            else:
                dictionary[nums[i]] = i
        
obj = Solution()
print(obj.twoSum([2,7,11,15],9))