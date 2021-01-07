# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # mapping = defaultdict()
        
        # #store the element : index
        # for i in range(len(nums)):
        #     if nums[i] not in mapping:
        #         mapping[nums[i]] = i
                
        # for i in range(len(nums)):
        #     complement = target - nums[i]
            
        #     if complement in mapping:
        #         if i != mapping[complement]:
        #             return [i, mapping[complement]]
        
        # return -1

        mapping = defaultdict()
        
        #populate the mapping
        for i in range(len(nums)):
            complement = target - nums[i]
            #if element not in mapping put it in there
            if nums[i] not in mapping:
                mapping[complement] = i
            else:
                return [i, mapping[nums[i]]]
                
        return -1
    """
    nums = [3,2,4]
    target = 6
    i = 0
    complement = 6 - 3
             mapping = { 3: 0}
    i = 1 
    complement = 6 - 2
                mapping = { 3: 0
                            4 : 1}
    i = 2
    complement = 6 - 4
                if         
    """