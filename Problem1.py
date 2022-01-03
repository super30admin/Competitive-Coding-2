# Time complexity = O(n)
# Space complexity = O(n)

def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hashMap = {}
        for i in range(len(nums)):
            if nums[i] in hashMap:
                return [i, hashMap[nums[i]]]
            else:
                complement = target - nums[i]
                hashMap[complement] = i