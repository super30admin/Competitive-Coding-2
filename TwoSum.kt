// In this problem, we have kept a hash map to store the numbers we have seen so far along with their indices.
// if we find a number such that the difference between the target and the current number exists in the map, we return the indices of these two numbers.
//Time Complexity: O(n) where n is the number of elements in the input array.
//Space Complexity: O(n) for the hash map storing the elements.

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for ((index,num) in nums.withIndex()) {
            val toCheck = target - num
            if (map.contains(toCheck))
            {
            return intArrayOf(map[toCheck]!!, index)
            }
            else {
            map.put(num, index)
            }
        }

        return intArrayOf(0,0)
    }
}