// Time Complexity :O(n) --> beacuse of for loop
// Space Complexity :O(n)  ---> because of Hashmap
import java.util.HashMap;

public class problem1 {
    public static int[] findindex(int[] nums,int target){
        if(nums.length == 0 || nums.length == 1)
            return new int[]{-1,-1};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]) && i != map.get(target-nums[i]))
                return new int[]{i,map.get(target-nums[i])};
            else
                map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(findindex(nums,target));
    }
}
