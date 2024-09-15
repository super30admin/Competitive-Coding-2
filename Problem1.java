import java.util.HashMap;

class solution{
    public static int[] twoSum(int[] nums, int target){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0; i<nums.length; i++){
            int rSum = target - nums[i];
            if(map.containsKey(rSum) && map.get(rSum) != i){
                return new int []{map.get(rSum), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int nums[]  = {2,7,11, 15};
        int target = 9;
        int[] indices = twoSum(nums, target);

        if (indices.length == 2) {
            System.out.println(indices[0] + " " + indices[1]);
        } else {
            System.out.println("No solution found!"); 
        }
    }
}

/*
Time complexity : 
O(n). We traverse the list containing n elements only once. Each look up in the table costs only O(1) time.

Space complexity : 
O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.

*/

