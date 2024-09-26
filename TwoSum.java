//Time Complexity : O(n) n->length of array
//Space Complexity : O(n) 
import java.util.HashMap;

public class TwoSum {
    public static int[] sum(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int result[] = new int[2];
        for(int i = 0 ; i < arr.length;i++)
        {
            int diff = target - arr[i];
            if(map.containsKey(diff)){
                result[0] = i;
                result[1] = map.get(diff);
                return result;
            }
            map.put(arr[i],i);

        }
        return result;

    }
    public static void main(String args[]) {
        int result[]=sum(new int[]{2,7,11,15},9);
        for(int i = 0; i < result.length;i++){
            System.out.println(result[i]);
        }
    }
}