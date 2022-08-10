import java.util.Arrays;

public class MergeTwoArrays {
    
    public static void main(String args[]) {
        int[] nums1= {1,2,3,4,0,0,0};
        int[] nums2 = {2,6,7};
        int p1 = 3;
        int p2 = 2;
        int index = nums1.length-1;

        while(p1 >= 0 && p2 >= 0) {
            System.out.println(p1 + " " + p2 + " " + index);
            if(nums1[p1] >= nums2[p2]) {
                nums1[index] = nums1[p1];
                p1--;
            }
            else if ( nums2[p2] > nums1[p1]) {
                nums1[index] = nums2[p2];
                p2--;
            }
            index--;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
