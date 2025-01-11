public class CountingWordsWithaGivenPrefix {
    // method - 1
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            boolean isPrefix = true;
            for (int i = 0; i < pref.length(); ++i) {
                if (i >= word.length() || word.charAt(i) != pref.charAt(i)) {
                    isPrefix = false;
                    break;
                }
            }
            if (isPrefix) {
                count++;
            }
        }
        return count;
    }

    // method - 2
    public int prefixCount(String[] words, String pref) {
        int counter = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                counter++;
            }
        }
        return counter;
    }
}
