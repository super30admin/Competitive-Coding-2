class Solution:
    #Time complexity - o(n) + o(n+1) ~ o(n)
    #Space Complexity - o(n)
    
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        hashTb = {}
        result = []

        for i in range(len(nums)):
            if nums[i] not in hashTb:
                hashTb[nums[i]] = i
            
        for i in range(len(nums)):
            compliment = target - nums[i]
            if compliment in hashTb and i!=hashTb[compliment]:
                result.append(i)
                result.append(hashTb[compliment])
                break

        return result
