package GFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class Levelordertraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList< ArrayList <Integer>> a=new  ArrayList <>();
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(root); 
        while (!q.isEmpty())
        { 
            ArrayList <Integer> temp=new ArrayList <Integer>();
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                Node t = q.poll(); 
                temp.add(t.data);
             
                if (t.left != null) 
                { 
                    q.add(t.left); 
                } 
    
                if (t.right != null) 
                { 
                    q.add(t.right); 
                }
            
            }
          a.add(temp);  
        }
        return a;
    }
}
