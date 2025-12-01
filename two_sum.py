class Solution:
    """
    ------------------------------------------------------------
    Two Sum Problem
    ------------------------------------------------------------
    Given:
      - nums[] : array of integers
      - target : integer value
    
    Goal:
      Return indices [i, j] such that:
          nums[i] + nums[j] == target
      Only one valid answer exists and you cannot reuse an element.
      Order of indices does not matter.

    Approaches:
      1. Brute Force – O(n^2)
      2. Sorting + Two Pointers – O(n log n)
           (Not valid here because sorting destroys original indices)
      3. Hash Map (Store value → index) – O(n)  ✔ Optimal
    ------------------------------------------------------------
    """

    def twoSum(self, nums, target):
        """
        ============================================================
        1. BRUTE FORCE – Check all pairs (i, j)
           Time: O(n^2), Space: O(1)
        
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        ============================================================
        """


        """
        ============================================================
        2. SORTING + TWO POINTERS – O(n log n)
           BUT NOT USABLE HERE 🔴
           Because sorting changes order → original indices lost.
        ============================================================
        """


        """
        ============================================================
        3. HASH MAP (Optimal) – O(n)
           - Store value → index
           - Check if `target - nums[i]` exists
           - Works because only one solution exists
        ============================================================
        """

        mp = {}  # value → index

        for i, num in enumerate(nums):
            need = target - num

            if need in mp:
                return [mp[need], i]  # found answer

            mp[num] = i  # store last seen index

        # Problem guarantees one valid answer, so no need for fallback.
