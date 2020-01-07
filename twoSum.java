package mock2;

//TC: O(n)
//SC: O(n)
import java.util.HashMap;

public class twoSum {

    public int[] findtar(int [] arr, int target){

        //Edge case
        if(arr == null || arr.length == 0){
            return new int[]{-1,-1};
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int diff = target - arr[i] ;
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            else{
                map.put(arr[i],i);
            }
        }

        return new int[]{-1,-1};
    }
    public static void main(String args[]){
        int arr[] = new int[]{2,7,11,15};
        int target = 9;

        int res[] = new int[2];

        res = new twoSum().findtar(arr,target);

        for(int i=0; i<2; i++){
            System.out.println(res[i]);
        }
    }
}
