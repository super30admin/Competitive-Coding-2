#time :
#space  :
#brute force -- i and j loops and j starts fro i+1 to end of array and try find the sum of elements =  target
#optimal, save complimennt of  target with the elemet in hashmap witht the elements index if the element does not exist
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hashmap = {}
        for i in range(len(nums)):
            if nums[i] in hashmap:
                return [i,hashmap[nums[i]]]
            else:
                hashmap[target - nums[i]] = i
