package static_Concept;
class Mobile
{
     String brand;
     int price;
     static String name;

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

public class Static 
{
   public static void main(String[] args) 
   {
       Mobile obj1 = new Mobile();
       obj1.brand = "Android";
       obj1.price = 5000;
    // obj1.name = "huhaa" it is also correct but not good practice
       Mobile.name = "huhaa"; // we can call static variavle by using the the class name itself


       Mobile obj2 = new Mobile();
       obj2.brand = "Apple";
       obj2.price = 14000;
    // obj1.name = "huhaa" it is also correct but not good practice
       Mobile.name = "huhaa"; // we can call static variavle by using the the class name itself


       Mobile.name = "Phone";  //it will set both the name --> phone of both the object

       obj1.show();
       obj2.show();

      Mobile.show1(obj1);  // directly call static method wit class name
      // Mobile.show1();  // directly call static method wit class name


   }    
}
