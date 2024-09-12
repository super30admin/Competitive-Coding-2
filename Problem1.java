// "static void main" must be defined in a public class.
//Two sum problem TC: O(n) SC: O(n)
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] a = {2,11,7,15};
        int target = 9;
        System.out.println("Indices are" +Arrays.toString(twoSum(a,target)));
    }

    public static int[] twoSum(int nums[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(nums.length == 0) return new int[]{};
        for(int i=0; i < nums.length; i++) {
            int digit = target - nums[i];
            if(map.containsKey(digit)) {
                return new int[] {i, map.get(digit)};
            } else {
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}