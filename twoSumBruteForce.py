# Time complexity: O(N^2)
# Space complexity: O(1)
# Compiled on leetcode?: Yes
# Problems faced while coding this: Yes

# In the 2nd for loop, after I fix the number, I was starting from the ith i index instead of i + 1 index,
# Therefore the same number was being added to the initially fixed number leading to the wrong answer
def twoSum(nums, target):
    for i in range(len(nums)):
        for j in range(i + 1, len(nums)):
            if nums[i] + nums[j] == target:
                return [i, j]    
    return -1    

def main():
    nums = [2, 7, 11, 15]
    target = 9
    print(twoSum(nums, target))
    
if __name__ == "__main__":
    main()