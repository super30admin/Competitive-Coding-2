class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #---------------------------Using Hashmap Time = O(n) ,Space = O(n)-------------------------------------------------------------------
        # hash_map = {}
        # for i in range(len(nums)):
        #     complement = target - nums[i]
        #     if complement in hash_map:
        #         return[hash_map[complement],i]
        #     hash_map[nums[i]]=i
        # return None

        #--------------------------Using Binary Search Time = O(nlogn) => to sort + O(nlogn) => Binary Search = O(nlogn), Space = O(n) => to store the indices--------------------------------------------
        # nums = [(num, idx) for idx, num in enumerate(nums)]
        # nums.sort()
        # for i in range(len(nums)):
        #     to_find = target - nums[i][0]
        #     low = i+1
        #     high = len(nums) - 1
        #     while low <= high:
        #         mid = low + (high-low)//2
        #         if nums[mid][0] == to_find:
        #             return [nums[mid][1], nums[i][1]]
        #         elif nums[mid][0] < to_find:
        #             low = mid + 1
        #         else:
        #             high = mid - 1

        #--------------------Two pointer appraoch Time=O(nlogn) + O(n), Space = O(n)--------------------------
        nums = [(num, idx) for idx, num in enumerate(nums)]
        nums.sort()
        l, r = 0, len(nums)-1
        while l < r:
            if nums[l][0] + nums[r][0] == target:
                return [nums[l][1], nums[r][1]]
            elif nums[l][0] + nums[r][0] < target:
                l = l + 1
            else:
                r = r - 1
            


