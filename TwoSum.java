class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        HashMap<Integer, Integer> m= new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            m.put(nums[i],i);
        }
        for(int i=0;i<n;i++)
        {   int x= target-nums[i];
            if(m.containsKey(x)){
                int idx = m.get(x);
                if(idx!=i)
                return new int[]{i,idx};
            }
        }

       return new int[]{-1,-1}; 
    }
}

//tc: O(n)
//sc: O(n)
//where n is the size of the array nums