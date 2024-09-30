#Approach
# maintain a hashmap to store the values and their index as kety and values
# If target-present value is present in hashmap add the present index and index prent in hashmap


#Complexities
#Time- O(n)
#Space- O(n)


from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        hashMap = dict()
        result = []
        for i in range(len(nums)):
            if (target - nums[i]) in hashMap:
                result.append(hashMap[target - nums[i]])
                result.append(i)
                break
            else:
                hashMap[nums[i]] = i

        return result
