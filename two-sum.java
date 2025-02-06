//time-complexity-O(n*n)
// space-complexity-O(1)


class Solution {
    public int[] twoSum(int[] nums, int target) {
    int m=nums.length;
    int n=target;
    int[] arr=new int[2];
    for(int i=0;i<m-1;i++){
         for(int j=i+1;j<m;j++){
        int num1=nums[i];
        // System.out.println("="+i+""+j+"");
        int num2=nums[j];
            if(num1 + num2 == target){
                 System.out.println("="+i+""+j+"");
                arr[0]=i;
                arr[1]=j;
            
        }else{

        }
         }
    }
    return arr;
    }
}



// solution HAshmap:
//time-complexity-O(n)
// space-complexity-O(n)
//
class Solution {
    public int[] twoSum(int[] nums, int target) {
    int low=0;
    int m=nums.length;
   int[] arr=new int[2];
    HashMap<Integer,Integer> sMap=new HashMap<>();
    for(int i=0;i<m;i++){
        int complimentValue=target-nums[i];
        if(!sMap.containsKey(complimentValue)){
            sMap.put(nums[i],i);
        }else{
            arr[0] = i;
            arr[1] =sMap.get(complimentValue); 
        }
    }
     return  arr;
    }
}
    
  
// solution HAshmap:
//time-complexity-O(nlogn)+n
// space-complexity-O(1)
//time -limit exceeded
class Solution {
    public int[] twoSum(int[] nums, int target) {
    int l=0;
    int r=nums.length-1;
   int[] arr=new int[2];
   Arrays.sort(nums);
   while(l<=r){
    int current = nums[l]+nums[r];
    if(current == target){
         arr[0]=l;arr[1]=r;
    }else if(current < target){
    l++;
    }else{
    r--;
    }
   }
     return  arr;
    }
}
    
  

   
    
  