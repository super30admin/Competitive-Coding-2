class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #initialising an hashmap
        dic=collections.defaultdict(int)
        for i in range(len(nums)):
            #substracting value from target for key
            key=target-nums[i];
            #checking condition for finding key in hashmap 
            if dic.get(nums[i])==None:
                dic[key]=i
            else:
                ans=[dic.get(nums[i]),i]  
                return ans