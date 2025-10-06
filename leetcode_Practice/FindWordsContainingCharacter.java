import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {
       public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> res = new ArrayList<>();

        int ln = words.length;

        for (int i = 0; i < ln; i++)
         {
            String subString = words[i];
            if (subString.contains(String.valueOf(x)))
            {    
               res.add(i);
            }
        }

        return res;
    }
}
