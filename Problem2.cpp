#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution{
public:
    int knapSack(vector<int>& val, vector<int>& wt, int weight){
        
        //array with rows = num of values, columns = weight limit + 1
        int arr[val.size()][weight+1];
        
        //fill first column as 0
        for(int x= 0; x<val.size(); x++)
            arr[x][0] = 0;
        
        //fill 1st row with the first value
        for(int x = 1; x<=weight;x++)
            arr[0][x] = val[0];
        
        for(int i = 1; i<val.size();i++){
            for(int j = 1; j<=weight; j++)
            {   
                //if column is less than the current weight copy from previous row
                if(j<wt[i])
                    arr[i][j] = arr[i-1][j];
                else
                    arr[i][j] = max(val[i]+arr[i-1][j-wt[i]],arr[i-1][j]);
                
            }
        }
        //return the last element of the last row 
        return arr[val.size()-1][weight];
    }
};

int main(){
    Solution s;
    vector<int> val{60,100,120};
    vector<int> wt{10,20,30};
    cout<<s.knapSack(val,wt,50);
}