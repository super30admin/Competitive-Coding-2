#Problem 1 : https://leetcode.com/problems/two-sum/
#Test Cases Passed on LeetCode
#Time Complexity-O(N)
#Space Complexity-O(N)
#Since it is mentioned in the question that each input would have 
#exactly one solution, we do not need to consider case when their is no output
class Solution:
    def twoSum(self, nums, target) :
        #create dictionary to store the elementss in nums and their index
        d={}
        for i in range(len(nums)):
            #to check whether the target-nums[i] exists in dictionary
            if target-nums[i] in d:
                #if it exists then we can return the current index
                # and index of the complement from dictionary
                return [i,d[target-nums[i]]]
            else:
                #otherwise we can simply add that element in dictionary
                d[nums[i]]=i

sol=Solution()
nums=[2,7,11,15]
print(sol.twoSum(nums))













