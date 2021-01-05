class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer,Integer> complements = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer num = nums[i];
            int complement = target - num;
            if(complements.containsKey(complement)){
                answer[0] = i;
                answer[1] = complements.get(complement);
            }else{
                complements.put(num, i);
            }
        }
        return answer;
    }
}