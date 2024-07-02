// Casting :- explicit conversion is called casting
// conversion:- Automatic conversion

class Typeconversioncasting
{
    public static void main (String args[])
    {
        //  byte b = 127;
        //  int a = 12;
          
        //      b = (byte)a;  // casting or explicit conversion
        //      a = b ;  //implicit conversion

         //most important 
         int a = 257;
         byte k = (byte) a;   // 257 % 256 == 1   // 256 is the range of byte
         System.out.println(k);  // output  ===  1
         //if the number which we type cast that is not fit in the range then it will modulus that number


         //TYpe promoting :-- if the value beyond the range then it will Promoted
         byte r = 20;
         byte p = 30;

         int result = r * p; // here result = 600 which is larger then the range of byte so it will converted into integer and stored 
         System.out.println(result);


    }
}