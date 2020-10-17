package com.intquetions;
// Java implementation to check whether a binary   (Every node have exaclty two chilren https://www.geeksforgeeks.org/check-whether-binary-tree-full-binary-tree-not-iterative-approach/?ref=rp)
// tree is a full binary tree or not 
import java.util.*; 
class FullBinaryTree {  
  
// structure of a node of binary tree  
static class Node {  
    int data;  
    Node left, right;  
} 
  
// function to get a new node  
static Node getNode(int data)  
{  
    // allocate space  
    Node newNode = new Node();  
  
    // put in the data  
    newNode.data = data;  
    newNode.left = null; 
    newNode.right = null;  
    return newNode;  
}  
  
// function to check whether a binary tree  
// is a full binary tree or not  
static boolean isFullBinaryTree(Node root)  
{  
    // if tree is empty  
    if (root == null)  
        return true;  
  
    // queue used for level order traversal  
    Queue<Node> q = new LinkedList<Node> ();  
  
    // push 'root' to 'q'  
    q.add(root);  
  
    // traverse all the nodes of the binary tree  
    // level by level until queue is empty  
    while (!q.isEmpty()) {  
        // get the pointer to 'node' at front  
        // of queue  
        Node node = q.peek();  
        q.remove();  
  
        // if it is a leaf node then continue  
        if (node.left == null && node.right == null)  
            continue;  
  
        // if either of the child is not null and the  
        // other one is null, then binary tree is not  
        // a full binary tee  
        if (node.left == null || node.right == null)  
            return false;  
  
        // push left and right childs of 'node'  
        // on to the queue 'q'  
        q.add(node.left);  
        q.add(node.right);  
    }  
  
    // binary tree is a full binary tee  
    return true;  
}  
  
// Driver program to test above  
public static void main(String[] args)  
{  
    Node root = getNode(1);  
    root.left = getNode(2);  
    root.right = getNode(3);  
    root.left.left = getNode(4);  
    root.left.right = getNode(5);  
  
    if (isFullBinaryTree(root))  
        System.out.println("Yes");  
    else
        System.out.println("No");  
}  
}  