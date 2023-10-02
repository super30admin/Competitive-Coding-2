'''
K Diff Pairs in an Array
1. We create a dictionary to store the frequency of each element in the array.
2. We iterate over keys and check if the key+k is present in the dictionary. If it is, we increment the count.
3. If k is 0, we check if the frequency of the key is greater than 1. If it is, we increment the count.
4. We return the count.

Time Complexity: O(n)
Space Complexity: O(n)
'''

class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:


        if nums == None or len(nums) == 0:
            return 0
        
        ct = 0
        dups=0
        uniques = {}

        for num in nums:
            if num in uniques:
                uniques[num]+=1
            else:
                uniques[num] = 1

        for num in uniques.keys():
            if num+k in uniques and k>0:
                ct += 1
            
            if uniques[num]>1 and k==0:
                ct+=1
        
        return ct