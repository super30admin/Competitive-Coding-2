//Timecplexity O(n^2)
//SpaceComplaxity O(1)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
          list.get(0).add(1);
        for(int i = 1; i< numRows; i++){          
            List<Integer> curr = new ArrayList<>(); 
            List<Integer> prev = new ArrayList<>();
            prev = list.get(i-1);
            
            for(int j = 0; j<= i; j++ ){
                if(j == 0 || j == i){
                    curr.add(1);
                }else{
                    curr.add(prev.get(j-1)+prev.get(j)) ;                    
                }                
            }
            list.add(curr);
        }
        return list;
    }
}
