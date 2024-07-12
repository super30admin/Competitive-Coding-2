class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        # Create a dictionary to count the occurrences of each number in the list
        myDict = {}
        for num in nums:
            if num not in myDict:
                myDict[num] = 0
            myDict[num] += 1
        
        # Initialize the counter for the number of pairs
        count = 0

        # Iterate through the dictionary to find valid pairs
        for key, value in myDict.items():
            # If k is positive, check if key + k exists in the dictionary
            if k > 0 and (key + k) in myDict:
                count += 1
            # If k is zero, check if there are at least two occurrences of the key
            elif k == 0 and value > 1:
                count += 1
        
        # Return the total count of valid pairs
        return count

# Time Complexity: O(n) iterate through the list once to create the dictionary.
# Space Complexity: O(n) to store the counts of each unique number in the dictionary.        

        


        
