/*

time complexity; O(N*M) n->number of elements in wts array, M-> target weight
Space Complexity: O(N*M)

*/


#include<iostream>
#include<vector>

using namespace std;

int max(int a,int b){
    return (a>b)?a:b;
}

int knapSack(int target,vector<int>& wts,vector<int>& profits){
    int n {static_cast<int>(wts.size())};
    vector<vector<int>> dp(n+1,vector<int> (target+1));

    if(target == 0) return 0;

    for(int i{1};i<=n;++i){
        for(int j{0};j<=target;++j){
            // if target weight is less than the weight of the object
            if(j<wts.at(i-1)){
                dp.at(i).at(j) = dp.at(i-1).at(j);
            }
            // if target weight is greater than the weight of the object
            else{
                dp.at(i).at(j) = max(dp.at(i-1).at(j),profits.at(i-1)+dp.at(i-1).at(j-wts.at(i-1))); 
            }
        }
    }

    return dp.at(n).at(target);

}

int main(int argc, char const *argv[])
{
    /* code */

    vector<int> profits{60,100,120};
    vector<int> wts{10,20,30};
    int target{50};
    cout<<knapSack(target,wts,profits);

    return 0;
}


