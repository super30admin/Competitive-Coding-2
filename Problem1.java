class Solution {
    /*
    time complexity: O(n) 
    space complexity : O(n) , in worst case scenarion we would traverse through all the elements
    
    
    
    */
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0){
            return new int[2];
        }
        
        HashMap<Integer,Integer> hmap = new HashMap<>();
        
        // for(int i = 0;i< nums.length;i++){
        //     if(!hmap.containsKey(nums[i])){
        //         hmap.put(nums[i],i);
        //     }
        // }
        
        for(int i = 0; i < nums.length;i++){
            int n1 = nums[i]; // 2 // 7 
            int remainder = target - n1;//9 -2 = 7  // 9 -7 = 2
            if(hmap.containsKey(remainder)){
                return new int[]{i,hmap.get(remainder)};
            }
            else{
                //add 2 and index in map
                hmap.put(n1, i); //(3,0) 
            }
            
        }
        //1, 2, 3 , target = 4 , this is the edge case for 2 loops
        //check one condiiton nums[i]
        
        //3,3 and target =6
        
        
        
        /*
        {2,7,11,15},target =9
         
         remainder = 9 -2 = 7
         if 7 is present, return index of 2 and get index of 7 from map
         otherwise, add 2 and its index in the map.
         
         
        */
        return new int[2];
    }
}
