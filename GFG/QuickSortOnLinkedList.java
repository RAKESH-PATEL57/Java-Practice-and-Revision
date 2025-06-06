package GFG;

import org.w3c.dom.Node;

public class QuickSortOnLinkedList {
    static void partition(Node pivot, Node left[], Node right[]){
        Node temp = pivot.next;
        while(temp!=null){
            Node nxt = temp.next;
            if(temp.data<=pivot.data){
                temp.next=left[0];
                left[0]=temp;
            }
            else{
                temp.next=right[0];
                right[0]=temp;
            }
            temp=nxt;
        }
    }
    public static Node quickSort(Node node) {
        // Your code here
        if(node==null || node.next==null)return node;
        Node left[]=new Node[1];
        Node right[]=new Node[1];
        partition(node,left,right);
        left[0] = quickSort(left[0]);
        right[0] = quickSort(right[0]);
        Node traversal = left[0];
        while(traversal!=null && traversal.next!=null)traversal=traversal.next;
        if(traversal!=null)traversal.next=node;
        else left[0]=node;
        node.next=right[0];
        return left[0];
    }
}
