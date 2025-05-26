//Time Complexity : O(n)
//Space Complexity : O(n)

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int y = target - nums[i];
            if(map.containsKey(y)){
                return new int[]{map.get(y),i};
            }
            map.put(nums[i],i);
            
        }        
        return new int[]{-1,-1};
    }

    public static void main(){
        TwoSum sum = new TwoSum();
        int[] nums =  [2,7,11,15];
        int target = 9;
        int[] result = sum.twoSum(nums,target);
        system.out.print('Result : ' +result);

        nums =  [3,2,4];
        target = 6;
        result = sum.twoSum(nums,target);
        system.out.print('Result : ' +result);

        nums =  [3,3];
        target = 6;
        result = sum.twoSum(nums,target);
        system.out.print('Result : ' +result);
    }
}