package GFG;

public class StringRotatedBy2Places {
    public static boolean isRotated(String s1, String s2) {
        
        if (s1.length() != s2.length()) 
        {
            return false;
        }
        
        int n = s1.length();
        

        if (n <= 2) 
        {
            return s1.equals(s2);
        }
        
        boolean clockwise = true;
        boolean anticlockwise = true;
        
        // Check clockwise rotation (s1 rotated 2 positions to the right matches s2)
        for (int i = 0; i < n; i++) 
        {
            if (s1.charAt(i) != s2.charAt((i + 2) % n)) 
            {
                clockwise = false;
                break;
            }
        }
        
        // Check anticlockwise rotation (s1 rotated 2 positions to the left matches s2)
        for (int i = 0; i < n; i++) 
        {
            if (s1.charAt((i + 2) % n) != s2.charAt(i)) 
            {
                anticlockwise = false;
                break;
            }
        }
        
        return clockwise || anticlockwise;
    }
}
