# Two elements sum to target
# Time Complexity: O(n) Space Complexity: O(n)
class Solution:
    def twoSum(self,nums:list[int], target: int)-> list[int]:
        # defining the empty map
        map ={}

        # iterating through the given list
        for index, number in enumerate(nums):
            #  finding the differnce
             difference = target - number
            # if the difference is present in the map
             if difference in map:
                #  if present then return that index and current index
                 return [map[difference], index]
            #  if not present then store the number and corresponing index
             else:
                 map[number] = index
         
    
solution = Solution()
print(solution.twoSum([2,7,11,15],9))