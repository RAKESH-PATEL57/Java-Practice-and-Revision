
class Calculator
{
    public void message()
    {
        System.out.println("Hello My Worst Day");
    }

    public int add(int n1, int n2)
    {
        int r = n1 + n2;
        return r;
    }
}

public class Methods
{
    public static void main(String[] args) 
    {
         int num1 = 50;    
         int num2 = 7;   
         
         Calculator calc = new Calculator();
         calc.message();

         int result = calc.add(num1, num2);

         System.out.println("summestion of " + num1 +" and " + num2 + " is " + result);
    }
}
