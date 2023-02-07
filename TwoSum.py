#All TC passed on leetcode

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        #Here we take a dictionary to store num as key and index as value. 
        #We traverse the array and check if target-num is available in dictionary 
        #if yes then return both indices i.e. current index and target-num index from dictionary. 
        #If not the add current num to dictionary.
        #Time complexity - O(n)
        #Space complexity - O(n)
        dict = {}
        res = []
        for i in range(len(nums)):
            if target-nums[i] in dict:
                res.append(i)
                res.append(dict[target-nums[i]])
                return res

            else:
                dict[nums[i]]=i

        return -1