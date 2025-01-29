package GFG;
import java.util.ArrayList;
import java.util.Arrays;

public class AlternativeSorting {
    public static ArrayList<Integer> alternateSort(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr);
        int i=0,j=n-1;
        for(int k=0;k<n;k++){
            if(k%2==1)ans.add(arr[i++]);
            else ans.add(arr[j--]);
        }
        return ans;
    }
}
