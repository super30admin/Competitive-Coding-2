"""Two Sums
Time Complexity: O(n)
Space Complexity: O(n)

approach-> use hashtable to store complement and index. 

 """


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hmap = {}
        diff =0
        
        #iterate
        for i in range(len(nums)):
            diff = target - nums[i]
            
            if diff in hmap: 
                return(i,hmap[diff])
            else:
                hmap[nums[i]]=i