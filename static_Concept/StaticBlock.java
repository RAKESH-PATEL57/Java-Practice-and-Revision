package static_Concept;
class Mobile
{
     String brand;
     int price;
     static String name;

     static
     {
        System.out.println("I am static method and call first dont need to create an object for me");
     }

     public void show()
     {
        System.out.println(brand + " : " + price + " : " + name);
     }

     
     public static void show1(Mobile obj)
     {
      System.out.println(obj.brand + " : " + obj.price + " : " + name);
      //   System.out.println("in static method");
     }

   //   public static void show1()
   //   {
   //    // System.out.println(brand + " : " + price + " : " + name); [[[  // it ill give an error because "brand and "price are not static variable it will creat confusion that which oobject's "brand" and "price" to be considered  ]]]
   //    //   System.out.println("in static method");
   //   }
}

public class StaticBlock 
{
   public static void main(String[] args) throws ClassNotFoundException 
   {
      
        Class.forName("Mobile");  // Mobile is our class

   }    
}
