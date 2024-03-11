# Time complexity is O(N) and space complexity is O(N)
class FindTwoSum:
    def twoSum(self, nums, target):
        dic = {}
        for i, num in enumerate(nums):
            diff = target - num
            if diff in dic:
                return [dic[diff], i]
            dic[num]=i
        return [-1, -1]
            