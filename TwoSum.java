// Time Complexity :O(n) where n is the length of nums
// Space Complexity :O(n) where n is the length of nums
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// two sum
// we create a hashmap which stores the value to be looked for (k=complement we are looking for, v= index of the original)
//  for element curr we check if the curr is present in the hashmap.(i.e if curr is the one we are looking out for)
// if not present we add the complement for curr
// if present we return the current index(complements) and the value(originals index)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                result[1] = i;
                result[0] = map.get(numbers[i]);
                return result;
            }
            map.put(target - numbers[i], i);
        }
        return result;
    }
}