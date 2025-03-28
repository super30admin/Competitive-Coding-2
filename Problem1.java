//TwoSum problem
//Time complexity - O(n)
//Space complexity - O(n)
//Did it run leetcode - Yes
//Approach - One hashmap of int,int is created which stores number and index and compliment of each no is used as key to check in map. If compliment is not present then add number and its index in map else return new array of index and its compliments index from map in array.
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmap = new HashMap<>();
        //stores number and index and compliment of each no is used as key to check in map

        for(int i = 0; i < nums.length; i++) {
            int compliment = target -  nums[i];
            if(!hmap.containsKey(compliment)) {
                hmap.put(nums[i], i);
            } else {
                return new int[]{i, hmap.get(compliment)};
            }
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solver.twoSum(nums1, target1);
        System.out.println("Indices for [2,7,11,15] (target=9): ["+ result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {1, 2, 5};
        int target2 = 10;
        int[] result2 = solver.twoSum(nums2, target2);
        System.out.println("Indices for [1,2,5] (target=10): ["+ result2[0] + ", " + result2[1] + "]");
    }
}