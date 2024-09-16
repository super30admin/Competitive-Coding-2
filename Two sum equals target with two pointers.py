# TC-O(n)
# SC-O(1)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        i=0
        j=len(nums)-1
        k=0
        while(k<=len(nums)):
            print(i, j)
            if nums[i]+nums[j]==target:
                return [i,j]
            else:
                if nums[i]+nums[j]>target:
                    j=j-1
                else:
                    i=i+1
            k=k+1