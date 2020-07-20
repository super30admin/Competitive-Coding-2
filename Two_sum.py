class Solution(object):
    def twoSum(self, nums, target):
        dic = {}

        res = []
        for i in range(len(nums)):
            if target - nums[i] in dic:
                res.append(dic[target - nums[i]])
                res.append(i)
                return res
            else:
                dic[nums[i]] = i