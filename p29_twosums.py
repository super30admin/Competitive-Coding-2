"""
:return We store in hashmap the values encountered in the array and also check if target minus the value we are encountering is already present in hashmap,
if yes we can return both the target-nums[i] and the the current value
TC:O(n)
Sc:O(n)
"""

class Solution:
    def twoSum(self, nums, target):
        # hashmap = dict()
        # for i in range(len(nums)):
        #     hashmap[nums[i]]=i
        #     if target-nums[i] in hashmap:
        #         return [hashmap[nums[i]], hashmap[target-nums[i]]]
        #
        # rev_table = dict()
        # for i in range(len(nums)):
        # 	second_addend = target - nums[i]
        # 	if second_addend in rev_table:
        # 		return [rev_table[second_addend], i]
        # 	else:
        # 		rev_table[nums[i]] = i


        hashmap=dict()
        for i in range(len(nums)):
            print("iteration", i)
            if target-nums[i] in hashmap:
                print("value", target-nums[i], "is present at index", hashmap[target-nums[i]])
                return [hashmap[target-nums[i]], i]
            print("adding ", nums[i], "at position", i)
            hashmap[nums[i]] = i






            # if nums[i] not in hashmap.keys():
            # hashmap[nums[i]]=i
            # result=target-nums[i]
            # if result in hashmap.keys():
            #     return [i, hashmap[result]]


            # hashmap[i]=nums[i]
            # if hashmap[i]<target:
            #     result=target-hashmap[i]
            # if hashmap.keys()==result:
            #     return [i, hashmap.get(result)]


nums=[3,2,4]
print(nums)
target=6
solve=Solution()
print(solve.twoSum(nums,target))

