# Time: O(n)
# Space O(n)

# first loop through the array and add all the elements in the hash_map
# then loop through the nums array one more time and check if the difference between the target and the element is there in the map 
# if yes then return the ith index and the index associated with the found element in the
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        my_map = {}

        for i in range(len(nums)):
            my_map[nums[i]] = i
        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in my_map and my_map[diff] != i:
                return [i,my_map[diff]]