class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # for i in range(0,len(nums)):
        #     for j in range(i+1,len(nums)):
        #         if target-nums[i] ==nums[j]:
        #             li=[i,j]
        #             break
        # return li

        dictNum={}

        for i in range(0,len(nums)):
            dictNum[nums[i]]=i

        print(dictNum)
        
        for i in range(0,len(nums)):
            comple=target-nums[i]
            if comple in dictNum:
                if i!=dictNum[comple]:
                    return [i,dictNum[comple]]
                    