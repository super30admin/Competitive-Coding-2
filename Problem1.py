# Time Complexity: O(N)
# Space Complexity: O(N)

# 2Sum Problem
# Here we create a hashmap to store the values and indices of the elements in the array
# when iterating over elements of the array, we check if the complement of the number
# is present in the array or not
# if it is present we return the current index and the index(stored in value) of the element in the hashmap
# else we add the current element to the hashmap with its index as its value

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        # Alternate approach
        #hashmap to save value with index
        value_map = dict()
        for i in range(len(nums)):
            complement = target-nums[i]
            if complement in value_map:
                return [i, value_map[complement]]
                #return current index and index of the complement of current element
            else:
                #if the current element's complement is not in the hashmap
                #add current element to the dictionary with the index
                value_map[nums[i]] = i


        #hashmap to save complements of numbers
        # complementMap = dict()
        # for i in range(len(nums)):
        #     complement = target - nums[i]

        #     if nums[i] in complementMap:
        #         return [complementMap[nums[i]], i]
        #         #return index of the complement of current element and current index
        #     else:
        #         #if the current element's complement is not in the hashmap
        #         #add it to the dictionary with the index
        #         complementMap[complement] = i
        #         #save the complement of current element with it's index