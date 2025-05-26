package GFG;

public class InsertInSortedCircularLinkedList {
    public Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);
  
  // Case 1: Empty list
  if (head == null) {
      newNode.next = newNode;
      return newNode;
  }
  
  // Case 2: Insert at the beginning (before head)
  if (data < head.data) 
  {
      newNode.next = head.next;
      head.next = newNode;
      
      int temp = head.data;
      head.data = newNode.data;
      newNode.data = temp;
      
      return head;
  }
  
  // Case 3: Insert in the middle or end
  Node current = head;
  while (current.next != head && current.next.data < data) 
  {
      current = current.next;
  }
  
  newNode.next = current.next;
  current.next = newNode;
  
  return head;
      
  }
}
