// Kanpsack problem
// dp solution
public static int optimalWeight(int[] wieghts, int[] vals, int capacity ){
    // edge
    if(wieghts == null || vals == null || capacity == 0) return 0;
    int[][] dp = new int[vals.length][capacity+1];
    for( int i=0; i < dp[0].length; i++){
        if(i >= wieghts[0]){
            dp[0][i] = vals[0];
        }
    }
    for( int i=1; i< dp.length; i++){
        for(int j =0; j<dp[0].length; j++){
            if(j >= wieghts[i]){
                dp[i][j] = Math.max(dp[i-1][j], vals[i]
                        +dp[i-1][j-wieghts[i]]
                );
            }else{
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    return dp[dp.length-1][dp[0].length-1];

// brute force solution
public static int optimalWeight(int[] wieghts, int[] vals, int capacity ){
        return helper(wieghts, vals, capacity,0,0);
    }
    private static int helper(int[] wieghts, int[] vals, int capacity, int i, int spent){
        //base
        if(capacity < 0 && i == wieghts.length){
            return 0;
        }
        if( capacity == 0){
            return spent;
        }
        if( i == wieghts.length){
            return spent;
        }
        //case1
        int skip = helper(wieghts, vals, capacity, i+1, spent);
        //case2
        int accept = helper(wieghts, vals, capacity-wieghts[i], i+1, spent+vals[i]);
        // answer
        return Math.max(skip, accept);
    }
