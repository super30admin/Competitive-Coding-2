#timecomplexity O(n)
#Spacecomplexity O(1) becouse returning list only
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # two pointer approch
        # one i will point to start and  j to last element 
        # will incriment 1 or decriment j as the sum of this index value greater then or less to             #target
        # new approch using hash map to store differece in target with value and checking difference number is in map or not 
        h={}       
        for i,val in enumerate(nums):
            n=target-val
            if n not in h.keys():
                h[val]=i
            else:
                return [h[n],i]
                    