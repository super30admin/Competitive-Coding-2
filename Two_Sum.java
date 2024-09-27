package Two_Sum;
import java.util.*;

public class Two_Sum {
	public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i=0; i<nums.length-1; i++){
            
            for(int j=i+1;j<nums.length;j++)
            {
                if((nums[i]+nums[j]) == target)
                {   
                    arr[0] = i;
                    arr[1] = j;
                    
                   
                    //break;
                }
                // else
                //     return 0;
               }
                 }
         return arr ;
    }

	public static void main(String[] args) {
		int[] arr = {2, 7, 11, 15};
		int target = 9;
		
		Two_Sum obj = new Two_Sum();
		 
		System.out.println(obj.twoSum(arr, target));
		
		
		
		

	}

}
