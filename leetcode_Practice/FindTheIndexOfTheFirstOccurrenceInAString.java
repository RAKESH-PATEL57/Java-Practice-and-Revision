public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle)
    {
        int hl = haystack.length();
        int nl = needle.length();

        int p1 = 0;
        int p2 = 0;
        int res= 0;

        while(p1<hl)
        {
            if(haystack.charAt(p1) == needle.charAt(p2))
            {
                p2++;
            }
            else
            { 
                p1=res;
                res = p1+1;
                p2=0;
            }
            if(p2==nl)
            {
                return res;
            }
            p1++;
        }

        return -1;
    }
}
