#First, I check if there's only one number in the list that matches the target. Then, I use two loops to compare every number with all the numbers that come after it. I add each pair of numbers and see if they equal the target. When I find a pair that adds up to the target, I immediately return their positions in the list. This method isn't the fastest, especially for big lists, but it's straightforward and gets the job done for smaller inputs. I know there are more efficient ways using hash tables, but I wanted to start with this basic approach to ensure I understood the problem thoroughly.

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if (len(nums) == 1) and (nums == target):
            return 0
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    return i,j