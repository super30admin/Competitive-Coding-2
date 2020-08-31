// Time Complexity :O(n*size_of_coins)
// Space Complexity : O(n*size_of_coins)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Beginnning of DP... Building the idea is hard as this point..

#include<iostream>

#include<map>
#include<vector>
using namespace std;
    int Knapsack(vector<int>& weights, vector<int>& values,int weight) {
        vector<vector<int> > mytable(values.size()+1,vector<int> (weight+1, 0));
        
        
        for (int k =0; k< values.size()+1; k++){
                mytable[k][0] = 0;
            }
            for (int k =1; k< weight+1; k++){
                mytable[0][k] = 0;
            }
        for (int i =1; i < values.size()+1; i++){
            for ( int j = 1; j < weight +1; j++){
               if (j < weights[i-1]){
                   mytable[i][j] = mytable[i-1][j];
               } 
                else {
                    mytable[i][j] =  max(mytable[i-1][j] , values[i] + mytable[i-1][j-weights[i-1]]);
                }
            }
            
            
        }
        return (mytable[values.size()][weight] >= 9999) ? -1: mytable[values.size()][weight] ;
    }



int main(){

    vector<int> arr = {60,100,120};
     vector<int> arr2 = {10,20,30};
    int wei = 50;
    int result = Knapsack(arr2,arr,wei);
        cout<< "the solution is "<<result<<endl;
    return 0;
}