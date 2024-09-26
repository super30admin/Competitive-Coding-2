
#time complexity O(n)
#space complexity:O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

def TwoSum(nums,target):
    d={}

    for i,val in enumerate(nums):
        remain=target-val

        if remain in d:
            return [d[remain],i]
        else:
            d[val]=i

def main():
    nums = [2,7,11,15]
    target = 9
    print(TwoSum(nums,target))
main()