//Two Sum Problem:
//TC: O(N)  //Traversing only once throughout the array to find the pair of the index matching the given sum result
//SC: O(N)  //Using HashMap to store each unique value coming into the array

class Solution {
    public int[] twoSum(int[] nums, int target) {
     
        int[] indexes=new int[2];
        
        if(nums.length==0 || nums==null){
            // indexes[0]=0;
            // indexes[1]=0;
            return indexes;
        }
        //return the indices of the indexes which match upto the sum given;
        
        
        HashMap<Integer, Integer> hmap=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            
            if(hmap.containsKey(nums[i])){
                indexes[0]=hmap.get(nums[i]);
                indexes[1]=i;
                return indexes;
            }
            hmap.put(target-nums[i],i);
        }
        
        return indexes;
        
    }
}
