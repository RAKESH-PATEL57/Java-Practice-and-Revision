import java.util.*;

public class Javat3
{
    public static void main(String[] args)
    {
        {
            Scanner sc = new Scanner(System.in);
            int age = sc.nextInt();
            if(age >= 18)
            {
                System.out.print("eligible for voting");
            }
            else
            {
                System.out.print("not eligible for voting");
            }
        }
    }
}