import java.util.ArrayList;

public class MissingAndRepeating {
     ArrayList<Integer> findTwoElement(int arr[])
    {
      
       ArrayList<Integer> res = new ArrayList<>();
       int rpt = 0;
       int missSml = 0;
       int temp[] = new int[arr.length];
       
       for(int i=0;i<arr.length;i++)
       {
           int num = arr[i] - 1;
           temp[num] += 1;
       }
       
       
       boolean missFinded = false;
       boolean rptFinded = false;
       
       for(int i=0;i<arr.length;i++)
       {
          if((temp[i] == 0) && missFinded == false)
          {
              missSml = i+1;
              missFinded = true;
          }
          if((temp[i] > 1) && rptFinded == false)
          {
              rpt = i+1;
              rptFinded = true;
          }
          
          if(((missFinded) == true ) && ((rptFinded) == true))
          {
              break;
          }
           
       }
       

       res.add(rpt);
       res.add(missSml);
       
       
       return res;
       
    }
}
