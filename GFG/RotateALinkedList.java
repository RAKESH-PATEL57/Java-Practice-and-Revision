package GFG;

import org.w3c.dom.Node;

public class RotateALinkedList {
    public Node rotate(Node head, int k)
    {
         if (head == null || k <= 0) return head;

        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        current.next = head;

        k = k % length;
        if (k == 0) {
            current.next = null; 
            return head;
        }

        int stepsToNewHead = k;
        Node newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        head = newTail.next;

       
        newTail.next = null;
        return head;
    }
}
