# Created by Aashish Adhikari at 10:59 AM 1/9/2021

'''
Time Complexity:
O(n)

Space Complexity:
O(n) to store all n elements in the hashmap.
'''

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hm = {}
        for idx in range(len(nums)):
            if nums[idx] not in hm:
                hm[nums[idx]] = [idx]
            else:
                hm[nums[idx]].append(idx)


        nums.sort()


        low = 0
        high = len(nums)-1

        while low < high:


            summ = nums[low] + nums[high]

            if summ < target:
                low += 1
            elif summ > target:
                high -= 1
            else:
                if len(hm[nums[low]]) == 1:

                    return [hm[nums[low]][0], hm[nums[high]][0]]
                else:
                    return [hm[nums[low]][0], hm[nums[low]][1]]
