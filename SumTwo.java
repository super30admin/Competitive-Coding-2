//Time: O(n)
//Space: O(n)
//ran on leetcode
//not too much difficulty

public class SumTwo {

    public static int[] sum_two(int[] nums, int target){
        //edge cases
        if(nums == null || nums.length == 0){
            int[] temp = {-1,-1};
            return temp;
        }

        HashMap<Integer,Integer> possible_nums = new HashMap<>();


        for(int i = 0; i < nums.length; i++){
            //find other number needed to reach target value
            int diff = target - nums[i];

            //check if its in the hashmap, return indices if it is
            if(possible_nums.containsKey(diff)){
                int[] result = {possible_nums.get(diff), i};
                return result;
            }
            else{
                possible_nums.put(nums[i], i);
            }
        }

        int[] res = {-1,-1};

        return res;


    }

    public static void main(String[] args) {
        int[] test = {3,2,1,5};
        System.out.println(Arrays.toString(sum_two(test,7)));

    }
}