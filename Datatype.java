// byte	    1 byte	    Stores whole numbers from -128 to 127
// short	2 bytes	    Stores whole numbers from -32,768 to 32,767
// int 	    4 bytes	    Stores whole numbers from -2,147,483,648 to 2,147,483,647
// long	    8 bytes 	Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
// float	4 bytes	    Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
// double	8 bytes	    Stores fractional numbers. Sufficient for storing 15 decimal digits
// boolean	1 bit	    Stores true or false values
// char	    2 bytes	    Stores a single character/letter or ASCII values
// data collected from https://www.w3schools.com/java/java_data_types.asp#:~:text=Data%20types%20are%20divided%20into,these%20in%20a%20later%20chapter)

class Datatype
{
    public static void main (String args[])
    {
            int num = 135;
            // byte by = 129 // it will give error becuage the last range of byte is 127
            byte by = 127; // not give error
            short sh = 558;
            long l = 55748l;  // we need to put "l" for long

            float f = 5.3f;
            double d = 5.2;

            char c = 'k';

            boolean b = true;
    }
}

// by default java has Double for point values
// float num = 6.5  // it will give error
// float num = 6.5f // it will not give error

//java has UNICODE not ASKIVALUE 

//BOOLEAN ----> true & false (ex- boolean b = true );