import java.util.HashMap;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] output = new int[2];
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];

            if(map.containsKey(diff)){
                output[0]=i;
                output[1]=map.get(diff);
                return output;
            }
            map.put(nums[i],i);

        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] res1 = TwoSum.twoSum(new int[]{2,7,11,15},9);
        int[] res2 = TwoSum.twoSum(new int[]{3,3},6);
        for(int each:res1){
            System.out.println(each);
        }
        for(int each:res2){
            System.out.println(each);
        }

    }
}