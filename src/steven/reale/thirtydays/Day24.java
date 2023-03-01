package steven.reale.thirtydays;

import java.util.Scanner;

/*
    A Node class is provided for you in the editor. A Node object has an integer data field, data, and a Node
    instance pointer, next, pointing to another node (i.e.: the next node in a list).

    A removeDuplicates function is declared in your editor, which takes a pointer to the head node of a linked list as
    a parameter. Complete removeDuplicates so that it deletes any duplicate nodes from the list and returns the head of
    the updated list.
 */

//given code begins here
class Node24 {
    int data;
    Node24 next;
    Node24(int d){
        data=d;
        next=null;
    }

}
class Day24
{
//given code ends here

    public static Node24 removeDuplicates(Node24 head) {
        //Write your code here
        Node24 currentNode = head;
        while(true) {

            while (currentNode.next != null && currentNode.data == currentNode.next.data) {
                currentNode.next = currentNode.next.next;
            }

            if (currentNode.next == null) break;
            currentNode = currentNode.next;
        }
        return head;
    }

//given code begins here
    public static Node24 insert(Node24 head, int data)
    {
        Node24 p=new Node24(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node24 start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node24 head)
    {
        Node24 start=head;
        while(start!=null)
        {
            System.out.print(start.data+" ");
            start=start.next;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Node24 head=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=insert(head,ele);
        }
        head=removeDuplicates(head);
        display(head);

    }
}