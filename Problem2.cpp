//provided solution 
//Time complexity o(N)
//space complexity O(N)

* Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    queue<TreeNode*>track;
private:
    void helper(TreeNode *root)
    {
        //base case
        if(root == NULL)
            return;
       //traverse
       //process
        track.push(root);
        if(root->left)
            helper(root->left);
        if(root->right)
            helper(root->right);
    }
public:
    void flatten(TreeNode* root) {
        if(root == NULL)
            return;
        helper(root);
        TreeNode *current = root;
        track.pop();
       //now once we have the queue
       while(!track.empty())
        {
            // Safely get the next node
            TreeNode* temp = track.front();
            track.pop();
            // Set right child and clear left child
            current->right = temp;
            current->left = NULL;
            // Move to the next node
            current = current->right;
        }
        return;
    }
};
///optimal solution with no additional space
void flatten(TreeNode* root) {
        //first we need to perfrom the preorder traversal
        //base case
        if(!root)
            return;
        //traverse
        flatten(root->left);
        flatten(root->right);
        //once we process each left and right child
        //we check if we have the
        TreeNode *temp = root->right;
        if(root->left)
        {
            root->right = root->left;
            root->left = nullptr;
            while(root->right)
            {
                root = root->right;
            }
            root->right = temp;
        }
    }