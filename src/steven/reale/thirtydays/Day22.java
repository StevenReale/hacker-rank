package steven.reale.thirtydays;

import java.util.Scanner;

/*
    The height of a binary search tree is the number of edges between the tree's root and its furthest leaf.
    You are given a pointer, root, pointing to the root of a binary search tree. Complete the getHeight function
    provided in your editor so that it returns the height of the binary search tree.
 */


//given code begins here
class Node22{
    Node22 left,right;
    int data;
    Node22(int data){
        this.data=data;
        left=right=null;
    }
}
class Day22{
//given code ends here

    public static int getHeight(Node22 root){
        //Write your code here
        if (root.left == null && root.right == null) {
            return 0;
        } else {
            int leftHeight = 0;
            int rightHeight = 0;
            if (root.left != null) leftHeight = getHeight(root.left);
            if (root.right != null) rightHeight = getHeight(root.right);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

//given code begins here
    public static Node22 insert(Node22 root,int data){
        if(root==null){
            return new Node22(data);
        }
        else{
            Node22 cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node22 root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}
