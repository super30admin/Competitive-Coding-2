//Problem : TWO Sum 

//Time complexity: O(N)
//space Complexity: O(N)
import java.util.HashMap;
public class Problem2{
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                if(hm.get(target-nums[i])!=i){
                    return new int[]{i,hm.get(target-nums[i])};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String args[]){
        int []nums = {2,7,11,15};
        int  target = 9;
        Problem2 obj=new Problem2();
        System.out.println(obj.twoSum(nums, target))
    }
}