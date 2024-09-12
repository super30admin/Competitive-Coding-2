//Time complexity is O(N)
//Space complexity is O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
        for(int i=0;i<nums.length;i++){
            List<Integer> li = hm.getOrDefault(nums[i], new ArrayList<Integer>());
            li.add(i);
            hm.put(nums[i], li);
        }
        for(int i=0;i<nums.length;i++){
            int remain = target-nums[i];
            if(hm.containsKey(remain)){
                System.out.println(i+"  " +remain);
                if(remain ==nums[i]){
                    if(hm.get(remain).size()>1)
                        return new int[]{hm.get(remain).get(0), hm.get(remain).get(1)};
                }
                else{
                    return new int[]{i, hm.get(remain).get(0)};
                }
            }
        }
        return new int[2];
    }
}

