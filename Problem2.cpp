// M : Weights
//N : Total Weight
//T : O(M*N)
//S : O(M*N)

#include <iostream>
#include <vector>
using namespace std;


int knapsack(vector<int> & W,vector<int> & V,int TW){

vector<vector<int>>dp (W.size()+1, vector<int>(TW+1, 0));

for(int i=0; i<= W.size();i++){
	for(int j = 0; j< TW+1; j++){
        if( i == 0 || j == 0){
            continue;
        }
		else if( j-W[i-1] >= 0 ){
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-W[i-1]]+V[i-1]);

		}else{
			dp[i][j] = dp[i-1][j];
		}
	}
}
for(auto i: dp){
    for(auto j: i){
        cout<<j<<" ";
    }
    cout<<endl;
}
return dp[W.size()-1][TW];

}


int main() {
    vector<int> W{1,3,4,5};
    vector<int> V {1,4,5,7};
    int TW = 7;
cout<<knapsack(W, V, TW);

    return 0;
}
