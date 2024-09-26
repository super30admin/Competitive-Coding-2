# Time complexity: O(N)
# Space complexity: O(N)
# Compiled on leetcode?: Yes
# Problems faced while coding this: No

def twoSum(nums, target):
    complementMap = {}
    for i in range(len(nums)):
         complement = target - nums[i]
         if nums[i] in complementMap:
             return [i, complementMap[nums[i]]]
         else:
             complementMap[complement] = i    

def main():
    nums = [2, 7, 11, 15]
    target = 9
    print(twoSum(nums, target))
    
if __name__ == "__main__":
    main()