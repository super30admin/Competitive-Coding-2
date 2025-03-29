'''Time and Space complexity:

TC = O(n) 
SC = O(n) 


Other Approaches can be explored are Two pointers and Binary search which gives  
Tc = O(n log n), Space= O(1) or O(n) (if preserving indices),

but the best optimal appraoch would be using Hashing as below without needing to sort the array,
'''

class Solution:

    def twoSum(self, nums, target):
        dict = {}

        for i, num in enumerate(nums):
            value = target - num

            if value in dict:
                return dict[value],i
            
            else:
                dict[num] = i

        return []

if __name__ == "__main__":
    nums = [3,5,7,9,6]
    target = 13
    result = Solution()
    print(result.twoSum(nums, target))