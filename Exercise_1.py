#Time Complexity : O(N), N being the length of the array. 
#Space Complexity : O(N), because the dictionary is created. 
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Had an issue with the indices repeating
# in the answer. 

#Your code here along with comments explaining your approach in three sentences only
'''Use a dictionary where the value is the key and the index is the dictionary value. 
Then for each value in array, see if target-value is in dictionary as key. If so, 
return the indices. 
'''
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #create dictionary
        dictionary = {}
        for i in range(len(nums)):
            if nums[i] not in dictionary.keys():
                dictionary[nums[i]]=[i]
            else:
                dictionary[nums[i]].append(i)
        result = []
        #iterate through array and find targe-value
        for i in range(len(nums)):
            find = target-nums[i]
            if find in dictionary.keys():
                ans = dictionary[find]
                #take care of the case where the values of indices are equal. 
                if len(ans)>1:
                    result.append(ans[0])
                    result.append(ans[1])
                    break
                else:
                    if i!=ans[0]:
                        result.append(ans[0])
                        result.append(i)
                        break
        return result