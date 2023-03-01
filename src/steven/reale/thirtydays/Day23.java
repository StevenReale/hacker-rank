package steven.reale.thirtydays;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    A level-order traversal, also known as a breadth-first search, visits each level of a tree's nodes from left to
    right, top to bottom. You are given a pointer, root, pointing to the root of a binary search tree. Complete the
    levelOrder function provided in your editor so that it prints the level-order traversal of the binary search tree
    as a space-separated line of integers.
 */

//given code begins here
class Node23 {
    Node23 left,right;
    int data;
    Node23(int data){
        this.data=data;
        left=right=null;
    }
}
class Day23{

    static void levelOrder(Node23 root){

//given code ends here
        Queue<Node23> nodeQueue = new LinkedList<>();
        Node23 currentNode;
        nodeQueue.add(root);

        while(nodeQueue.size() > 0) {
            currentNode = nodeQueue.poll();
            System.out.print(currentNode.data + " ");

            if (currentNode.left != null) nodeQueue.add(currentNode.left);
            if (currentNode.right != null) nodeQueue.add(currentNode.right);
        }

    }

//given code begins here
    public static Node23 insert(Node23 root, int data){
        if(root==null){
            return new Node23(data);
        }
        else{
            Node23 cur;
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
        Node23 root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
    }
}
