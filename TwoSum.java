// Time Complexity o(n) Space Comlexity o(1);
public class TwoSum {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,7};
        int target = 11;
        int p1=0,p2=arr.length-1;
        while(p1<p2){
            if(arr[p1]+arr[p2]>target){
                p2--;
            }
            else if(arr[p1]+arr[p2]<target){
                p1++;
            }
            else{
                System.out.println(arr[p1] + "+" + arr[p2] + "=" + target);
                break;
            }
        }
    }
    
}
