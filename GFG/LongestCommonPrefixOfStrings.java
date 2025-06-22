package GFG;

public class LongestCommonPrefixOfStrings {
    public String longestCommonPrefix(String arr[]) {
        // code here
        if (arr == null || arr.length == 0) return "";
        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) 
        {
            while (!arr[i].startsWith(prefix)) 
            {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
