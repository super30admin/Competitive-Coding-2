Time Complexity: O(n^2)
Space Complexity: O(n^2)
solved on leetcode: yes
any problems faced: no
// Approach: We can generate the pascal triangle by using the previous row. The first and last element of each row is 1 and the rest of the elements are the sum of the two elements above it in the previous row.
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriange = new ArrayList<>();
        List<Integer> previous = new ArrayList<>();
        previous.add(1);
        pascalTriange.add(previous);
        for(int i = 1;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    temp.add(1);
                }
                else{
                    temp.add(previous.get(j-1) + previous.get(j));
                }
            }
            pascalTriange.add(temp);
            previous = temp;
        } 
        return pascalTriange;
    }
}