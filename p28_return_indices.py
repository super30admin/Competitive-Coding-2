Time complexity - O(n)
space complexity - O(1)
Ran on leetcode - Yes
Faced issues - Yes . In python to retrieve the key for that particular value we dont have a inbuilt function whereas this problem can be done easily in java 

Code Description:
The following problem well in brute force i.eO(n2) but i tried to do it in O(n).I used a dictinary to store all the values in dictionary and while traversing through the list i checked if target-nums[i] is present or not in the list.If yes i return the both the indices.


class Solution(object):
    def dict_search(self,d,i,remain):
        for key,value in d.items():
            if key!=i and d[key]==remain:
                return key
                break
        return -1
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        out=[]
        d=dict()
        if len(nums)==0 or nums==None:
            return out
        for i in range(len(nums)):
            d[i]=nums[i]
        for i in range(len(nums)):
            remain=target-nums[i]
            if remain in d.values() and self.dict_search(d,i,remain)>=0:
                break
        return([i,self.dict_search(d,i,remain)])