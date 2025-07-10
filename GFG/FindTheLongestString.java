package GFG;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTheLongestString {
    public String longestString(String[] words) {
        // code here
        Arrays.sort(words); // For lexicographical order
        Set<String> built = new HashSet<>();
        String answer = "";
        built.add(""); // To allow single-letter words

        for (String word : words)
        {
            String prefix = word.substring(0, word.length() - 1);
            if (built.contains(prefix))
            {
                built.add(word);
                if (word.length() > answer.length() || (word.length() == answer.length() && word.compareTo(answer) < 0))
                {
                    answer = word;
                }
            }
        }
        return answer;
    }
}
