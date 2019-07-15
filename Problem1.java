import java.util.*;
public class problem1 {

    public static int[] findSum(int[] arr, int target) {
        LinkedHashSet<Integer> numSet = new LinkedHashSet<Integer>();
        int arr1[] = {-1,-1};
        for(int i=0;i<arr.length;i++) {
            numSet.add(arr[i]);
            if(numSet.contains(target-arr[i])) {
                arr1[0] = new ArrayList<>(numSet).indexOf(target-arr[i]);
                arr1[1] = i;
                break;
            }
        }
            return arr1;
        
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        for(int i=0;i<(findSum(arr,target)).length;i++){
            System.out.println(findSum(arr,target)[i]);
        }
    }
}