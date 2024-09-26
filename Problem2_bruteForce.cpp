/*

Brute Force algorithm for knapsack.

Time Complexity : 2^(n), n-> number of elements;
Space Complexity: O(n) n->number of stack calls.

*/

#include<iostream>
#include<vector>

using namespace std;

int max(int a, int b){
    return (a>b)?a:b;
}

int knapsack(int curr_wt,vector<int>& wts,vector<int>& profits,int idx){

    //base case

    if(idx < 0) return 0;
    if(curr_wt == 0) return 0;

    // checking if the weight of the element is greater than the curr_wt.
    if(wts.at(idx)>curr_wt){
        return knapsack(curr_wt,wts,profits,idx-1);
    }
    else{
        return max(profits.at(idx)+knapsack(curr_wt - wts.at(idx),wts,profits,idx-1),knapsack(curr_wt,wts,profits,idx-1));
    }
}

int main(){
    vector<int> profit {20,13,49,23};
    vector<int> wts {3,6,1,5};
    int target {12};
    int len = profit.size() -1;

    cout<< knapsack(target,wts,profit,len);
    return 0;
}