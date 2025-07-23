//Time Complexity (TC):O(n) — We traverse the array once, and each lookup/insert in the HashMap takes O(1) on average.
//Space Complexity (SC):O(n) — In the worst case, we store all n elements in the HashMap.

//Use a HashMap to store each number and its index as you iterate through the array.
//For each number, calculate the complement (target - number).
//If the complement is already in the map, return its index and the current index.

class Solution {
    public int[] twoSum(int[] numbers, int targetSum) {
        HashMap<Integer, Integer> numberToIndexMap = new HashMap<>();

        for (int currentIndex = 0; currentIndex < numbers.length; currentIndex++) {
            int complement = targetSum - numbers[currentIndex];
            if (numberToIndexMap.containsKey(complement)) {
                return new int[]{numberToIndexMap.get(complement), currentIndex};
            }
            numberToIndexMap.put(numbers[currentIndex], currentIndex);
        }

        return new int[]{};
    }
}
