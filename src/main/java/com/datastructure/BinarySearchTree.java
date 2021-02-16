package com.datastructure;

import com.beans.TreeNode;

public class BinarySearchTree<T extends Comparable<T>> {

  // Tracks the number of nodes in this BST
  private int nodeCount = 0;

  // This BST is a rooted tree so we maintain a handle on the root node
  private Node root = null;

  // Internal node containing node references
  // and the actual node data
  private class Node {
    T data;
    Node left, right;

    public Node(Node left, Node right, T elem) {
      this.data = elem;
      this.left = left;
      this.right = right;
    }

	public Node(Object left2, Object right2, int i) {
	}

  }

  // Check if this binary tree is empty
  public boolean isEmpty() {
    return size() == 0;
  }

  // Get the number of nodes in this binary tree
  public int size() {
    return nodeCount;
  }

  // Add an element to this binary tree. Returns true
  // if we successfully perform an insertion
  public boolean add(T elem) {

    // Check if the value already exists in this
    // binary tree, if it does ignore adding it
    if (contains(elem)) {
      return false;

      // Otherwise add this element to the binary tree
    } else {
      root = add(root, elem);
      nodeCount++;
      return true;
    }
  }

  // Private method to recursively add a value in the binary tree
  private Node add(Node node, T elem) {

    // Base case: found a leaf node
    if (node == null) {
      node = new Node(null, null, elem);

    } else {
      // Pick a subtree to insert element
      if (elem.compareTo(node.data) < 0) {
        node.left = add(node.left, elem);
      } else {
        node.right = add(node.right, elem);
      }
    }

    return node;
  }

  // Remove a value from this binary tree if it exists, O(n)
  public boolean remove(T elem) {

    // Make sure the node we want to remove
    // actually exists before we remove it
    if (contains(elem)) {
      root = remove(root, elem);
      nodeCount--;
      return true;
    }
    return false;
  }

  private Node remove(Node node, T elem) {

    if (node == null) return null;

    int cmp = elem.compareTo(node.data);

    // Dig into left subtree, the value we're looking
    // for is smaller than the current value
    if (cmp < 0) {
      node.left = remove(node.left, elem);

      // Dig into right subtree, the value we're looking
      // for is greater than the current value
    } else if (cmp > 0) {
      node.right = remove(node.right, elem);

      // Found the node we wish to remove
    } else {

      // This is the case with only a right subtree or
      // no subtree at all. In this situation just
      // swap the node we wish to remove with its right child.
      if (node.left == null) {
        return node.right;

        // This is the case with only a left subtree or
        // no subtree at all. In this situation just
        // swap the node we wish to remove with its left child.
      } else if (node.right == null) {

        return node.left;

        // When removing a node from a binary tree with two links the
        // successor of the node being removed can either be the largest
        // value in the left subtree or the smallest value in the right
        // subtree. In this implementation I have decided to find the
        // smallest value in the right subtree which can be found by
        // traversing as far left as possible in the right subtree.
      } else {

        // Find the leftmost node in the right subtree
        Node tmp = findMin(node.right);

        // Swap the data
        node.data = tmp.data;

        // Go into the right subtree and remove the leftmost node we
        // found and swapped data with. This prevents us from having
        // two nodes in our tree with the same value.
        node.right = remove(node.right, tmp.data);

        // If instead we wanted to find the largest node in the left
        // subtree as opposed to smallest node in the right subtree
        // here is what we would do:
        // Node tmp = findMax(node.left);
        // node.data = tmp.data;
        // node.left = remove(node.left, tmp.data);

      }
    }

    return node;
  }

  // Helper method to find the leftmost node (which has the smallest value)
  private Node findMin(Node node) {
    while (node.left != null) node = node.left;
    return node;
  }

  // Helper method to find the rightmost node (which has the largest value)
  private Node findMax(Node node) {
    while (node.right != null) node = node.right;
    return node;
  }

  // returns true is the element exists in the tree
  public boolean contains(T elem) {
    return contains(root, elem);
  }

  // private recursive method to find an element in the tree
  private boolean contains(Node node, T elem) {

    // Base case: reached bottom, value not found
    if (node == null) return false;

    int cmp = elem.compareTo(node.data);

    // Dig into the left subtree because the value we're
    // looking for is smaller than the current value
    if (cmp < 0) return contains(node.left, elem);

    // Dig into the right subtree because the value we're
    // looking for is greater than the current value
    else if (cmp > 0) return contains(node.right, elem);

    // We found the value we were looking for
    else return true;
  }

  // Computes the height of the tree, O(n)
  public int height() {
    return height(root);
  }

  // Recursive helper method to compute the height of the tree
  private int height(Node node) {
    if (node == null) return 0;
    return Math.max(height(node.left), height(node.right)) + 1;
  }

  // This method returns an iterator for a given TreeTraversalOrder.
  // The ways in which you can traverse the tree are in four different ways:
  // preorder, inorder, postorder and levelorder.
  public java.util.Iterator<T> traverse(TreeTraversalOrder order) {
    switch (order) {
      case PRE_ORDER:
        return preOrderTraversal();
      case IN_ORDER:
        return inOrderTraversal();
      case POST_ORDER:
        return postOrderTraversal();
      case LEVEL_ORDER:
        return levelOrderTraversal();
      default:
        return null;
    }
  }

  // Returns as iterator to traverse the tree in pre order   ***************DFS*(DEFTH FIRST)************
  private java.util.Iterator<T> preOrderTraversal() {

    final int expectedNodeCount = nodeCount;
    final java.util.Stack<Node> stack = new java.util.Stack<>();
    stack.push(root);

    return new java.util.Iterator<T>() {
      @Override
      public boolean hasNext() {
        if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
        return root != null && !stack.isEmpty();
      }

      @Override
      public T next() {
        if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
        Node node = stack.pop();
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
        return node.data;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }

  // Returns as iterator to traverse the tree in order ***************DFS*************
  private java.util.Iterator<T> inOrderTraversal() {

    final int expectedNodeCount = nodeCount;
    final java.util.Stack<Node> stack = new java.util.Stack<>();
    stack.push(root);

    return new java.util.Iterator<T>() {
      Node trav = root;

      @Override
      public boolean hasNext() {
        if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
        return root != null && !stack.isEmpty();
      }

      @Override
      public T next() {

        if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();

        // Dig left
        while (trav != null && trav.left != null) {
          stack.push(trav.left);
          trav = trav.left;
        }

        Node node = stack.pop();

        // Try moving down right once
        if (node.right != null) {
          stack.push(node.right);
          trav = node.right;
        }

        return node.data;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }

  // Returns as iterator to traverse the tree in post order  ***************DFS*************
  private java.util.Iterator<T> postOrderTraversal() {
    final int expectedNodeCount = nodeCount;
    final java.util.Stack<Node> stack1 = new java.util.Stack<>();
    final java.util.Stack<Node> stack2 = new java.util.Stack<>();
    stack1.push(root);
    while (!stack1.isEmpty()) {
      Node node = stack1.pop();
      if (node != null) {
        stack2.push(node);
        if (node.left != null) stack1.push(node.left);
        if (node.right != null) stack1.push(node.right);
      }
    }
    return new java.util.Iterator<T>() {
      @Override
      public boolean hasNext() {
        if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
        return root != null && !stack2.isEmpty();
      }

      @Override
      public T next() {
        if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
        return stack2.pop().data;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }

  // Returns as iterator to traverse the tree in level order ***************BFS  Breath -FIRST*************
  private java.util.Iterator<T> levelOrderTraversal() {

    final int expectedNodeCount = nodeCount;
    final java.util.Queue<Node> queue = new java.util.LinkedList<>();
    queue.offer(root);

    return new java.util.Iterator<T>() {
      @Override
      public boolean hasNext() {
        if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
        return root != null && !queue.isEmpty();
      }

      @Override
      public T next() {
        if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
        Node node = queue.poll();
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
        return node.data;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  
  //Create Binary Search Tree (BST CREATION) from array element recursively
  /* A function that constructs Balanced Binary Search Tree  
  from a sorted array */
 Node sortedArrayToBST(int arr[], int start, int end) { 

     /* Base Case */
     if (start > end) { 
         return null; 
     } 

     /* Get the middle element and make it root */
     int mid = (start + end) / 2;
     /*****UNCOMMENT******/
     Node node = new Node(null,null,arr[mid]); 

     /* Recursively construct the left subtree and make it 
      left child of root */
     node.left = sortedArrayToBST(arr, start, mid - 1); 

     /* Recursively construct the right subtree and make it 
      right child of root */
     node.right = sortedArrayToBST(arr, mid + 1, end); 
       
     return node; 
 } 
 
 //669. Trim a Binary Search Tree
 //https://www.youtube.com/watch?v=JNAqFV9AgVc
 public TreeNode trimBST(TreeNode root, int low, int high) {
  if (root == null) {
      return null;
  }
  if((int)root.val<low){ //then ans will be in right coz of property of BST all left will be smaller
      return trimBST(root.right,low,high);
  }else if((int)root.val>high){ //ans will be on right
      return trimBST(root.left,low,high);
  }
  //if both above is not true then root is the answer with updated left and right sub-tree
    root.left=trimBST(root.left,low,high);
    root.right=trimBST(root.right,low,high);
      
  return root;
}
 //1038. Binary Search Tree to Greater Sum Tree
 int sum=0;
 public TreeNode bstToGst(TreeNode root) {
     Stack<TreeNode> st = new Stack<>();
		TreeNode current = root;

		while (!st.isEmpty() || current != null) {
			if (current != null) {
				st.push(current);
				current = current.right;
			} else {
			 TreeNode node = st.pop();
             sum+=(int)node.val;
             node.val=sum;
				current = node.left;
			}

		}
     return root;
 }
 //alternate solution  reverse of inorder in both solutions
 public TreeNode bstToGst2(TreeNode root) {
     if(root==null)
         return null;
      bstToGst2(root.right);
      sum+=(int)root.val;
      root.val=sum;
      bstToGst2(root.left);
      return root;
      
  }
}