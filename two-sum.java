import java.util.*;
class Main{
  public static void main(String []args){
    int []nums={2,7,11,15};
    int target=9;
    int []ar=findLocations(nums, target);
    for(int i:ar){
      System.out.println(i);
    }
  }
  public static int[] findLocations(int []nums, int target){
    if(nums.length<2){
      return new int[] {-1, -1};
    }
    HashMap<Integer, Integer> map=new HashMap<>();
    int []result=new int [2];
    for(int i=0;i<nums.length;i++){
      int temp=target-nums[i];
      if(!map.containsKey(temp)){
        map.put(nums[i], i);
      } else {
          result[0]= map.get(temp);
          result[1]=i;
      }
    }
    return result;
  }
}