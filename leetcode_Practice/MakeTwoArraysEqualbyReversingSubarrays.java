import java.util.Arrays;

public class MakeTwoArraysEqualbyReversingSubarrays 
{
    public boolean canBeEqual(int[] target, int[] arr) 
    {
        Arrays.sort(target);    
        Arrays.sort(arr);

        boolean res = Arrays.equals(target,arr);

        return res;
    }    
}
