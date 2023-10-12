# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict = {}
        idx_lst = []
        
        for i in range(0, len(nums)):
            dict[nums[i]] = i
        
        for i in range(0, len(nums)):
            if (target-nums[i]) in dict:
                if(i==dict[target-nums[i]]):
                    continue
                idx_lst.append(i)
                idx_lst.append(dict[(target-nums[i])])
                break
        
        return idx_lst
            