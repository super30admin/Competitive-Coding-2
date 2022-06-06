//0-1 Knapsack

//Time Complexity- O(elements*W)
//Space Complexity- O(elements*W)

int knapsack(int W,vector<int> &weights,vector<int> &values){

    if(weights.size()==0 || W==0){
        return 0;
    }

    vector<vector<int>> dp(weights.size()+1,vector<int>(W+1,0));

    for(int i=1;i<=weights.size();i++){
        for(int weight=1;weight<=W;weight++){
            if(weight>=weights[i-1]){
                dp[i][weight]=max(dp[i-1][weight-weights[i-1]]+values[i-1],dp[i-1][weight]);
            }
            else{
                dp[i][weight]=dp[i-1][weight];
            }
        }
    }
    return dp[weights.size()][W];
}

int main(){

    vector<int> weights={10,20,30};
    vector<int> values={60,100,120};
    int W=50;

    cout<<knapsack(W,weights,values)<<endl;
}