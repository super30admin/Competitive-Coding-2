import java.util.*;
class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    int [] arr = new int[] {2,3,4,6,8,9};
    int target= 15;
    int [] res= (twoSum(arr,target));
    for(int i=0;i<res.length;i++){
      System.out.println(res[i]);
    }

  }
  public static int[] twoSum(int [] arr, int target){
    HashMap<Integer, Integer> map = new HashMap<>();      
    for(int i=0;i<arr.length;i++){
      map.put(arr[i],i);
    }
    for(int j=0;j<arr.length;j++){
      if(map.containsKey(target-arr[j])){
        return new int[]{map.get(target-arr[j]),j}; 
      }
    }
    return new int[] {-1,-1};
  }
  
}


//Time Complexity : O(n)
//Space Complexity: O(n)
